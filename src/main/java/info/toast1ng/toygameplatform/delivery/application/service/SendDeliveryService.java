package info.toast1ng.toygameplatform.delivery.application.service;

import info.toast1ng.toygameplatform.account.application.port.out.LoadAccountItemPort;
import info.toast1ng.toygameplatform.account.application.port.out.LoadAccountPort;
import info.toast1ng.toygameplatform.account.application.port.out.UpdateAccountItemPort;
import info.toast1ng.toygameplatform.account.application.port.out.UpdateAccountPort;
import info.toast1ng.toygameplatform.account.domain.Account;
import info.toast1ng.toygameplatform.account.domain.AccountItem;
import info.toast1ng.toygameplatform.common.GoldType;
import info.toast1ng.toygameplatform.common.domain.Gold;
import info.toast1ng.toygameplatform.delivery.application.port.in.SendDeliveryCommand;
import info.toast1ng.toygameplatform.delivery.application.port.in.SendDeliveryUseCase;
import info.toast1ng.toygameplatform.delivery.application.port.out.RegisterDeliveryPort;
import info.toast1ng.toygameplatform.delivery.domain.Delivery;
import info.toast1ng.toygameplatform.delivery.domain.DeliveryItem;
import info.toast1ng.toygameplatform.delivery.domain.DeliveryState;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@RequiredArgsConstructor
@Transactional
@Service
public class SendDeliveryService implements SendDeliveryUseCase {
    private final LoadAccountItemPort loadAccountItemPort;
    private final LoadAccountPort loadAccountPort;
    private final UpdateAccountPort updateAccountPort;
    private final UpdateAccountItemPort updateAccountItemPort;
    private final RegisterDeliveryPort registerDeliveryPort;

    @Override
    public void sendDelivery(SendDeliveryCommand command) throws Exception {
        Account receiverAccount = loadAccountPort.loadAccount(command.getReceiverUsername());

        if (command.getSenderId() == receiverAccount.getId()) throw new Exception("don't send to yourself");

        Map<Long, Integer> requestProductIdAmountMap = new HashMap<>();
        for (SendDeliveryCommand.DeliveryItemInfo requestItemInfo : command.getItems()) {
            requestProductIdAmountMap.put(requestItemInfo.getProductId(),
                    requestProductIdAmountMap.getOrDefault(requestItemInfo.getProductId(),0) + requestItemInfo.getAmount());
        }
        List<AccountItem> accountItems = loadAccountItemPort.loadAccountItemsByProductIds(command.getSenderId(), requestProductIdAmountMap.keySet());

        Account senderAccount = loadAccountPort.loadAccount(command.getSenderId());
        Gold totalGold = new Gold(command.getRuby());

        if (!senderAccount.getGrade().equals(Account.AccountGrade.admin)) {
            if (!senderAccount.isAbleToPay(GoldType.ruby, totalGold)) throw new Exception("player doesn't have money");
            subtractRuby(senderAccount, totalGold);
        }
        subtractAccountItems(requestProductIdAmountMap, accountItems);

        List<DeliveryItem> deliveryItems = new ArrayList<>();
        for (AccountItem accountItem : accountItems) {
            deliveryItems.add(DeliveryItem.builder()
                    .product(accountItem.getProduct())
                    .amount(requestProductIdAmountMap.get(accountItem.getProduct().getId()))
                    .build());
        }

        registerDeliveryPort.createDelivery(Delivery.builder()
                .sender(senderAccount)
                .receiver(receiverAccount)
                .items(deliveryItems)
                .ruby(totalGold)
                .date(new Date())
                .state(DeliveryState.wait)
                .build());
    }

    private void subtractAccountItems(Map<Long, Integer> requestProductIdAmountMap, List<AccountItem> accountItems) throws Exception {
        //TODO lock account item
        for (AccountItem accountItem : accountItems) {
            Integer requestProductAmount = requestProductIdAmountMap.get(accountItem.getProduct().getId());
            if (!accountItem.isAbleToDelivery(requestProductAmount)) throw new Exception("player doesn't have this item");
            accountItem.delivery(requestProductAmount);
            updateAccountItemPort.updateAccountItem(accountItem);
        }
        //TODO unlock account item
    }

    private void subtractRuby(Account senderAccount, Gold totalGold) {
        //TODO lock account
        senderAccount.payGold(GoldType.ruby, totalGold);
        updateAccountPort.updateAccount(senderAccount);
        //TODO unlock account
    }

}
