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
        if (command.getSenderId() == command.getReceiverId()) throw new Exception("don't send to yourself");

        Account receiverAccount = loadAccountPort.loadAccount(command.getReceiverId());

        Map<Long, Integer> requestItemIdAmountMap = new HashMap<>();
        for (SendDeliveryCommand.DeliveryItemInfo requestItemInfo : command.getItems()) {
            requestItemIdAmountMap.put(requestItemInfo.getItemId(),
                    requestItemIdAmountMap.getOrDefault(requestItemInfo.getItemId(),0) + requestItemInfo.getAmount());
        }

        List<DeliveryItem> deliveryItems = new ArrayList<>();

        List<AccountItem> accountItems = loadAccountItemPort.loadAccountItems(command.getSenderId(), requestItemIdAmountMap.keySet());

        for (AccountItem accountItem : accountItems) {
            Integer requestProductAmount = requestItemIdAmountMap.get(accountItem.getId());
            if (!accountItem.isAbleToDelivery(requestProductAmount)) throw new Exception("item not ready");

            deliveryItems.add(DeliveryItem.builder()
                    .product(accountItem.getProduct())
                    .amount(requestProductAmount)
                    .build());
        }

        Account senderAccount = loadAccountPort.loadAccount(command.getSenderId());
        Gold totalGold = new Gold(command.getRuby());
        if (!senderAccount.isAbleToPay(GoldType.ruby, totalGold)) throw new Exception("money not ready");

        //TODO lock account
        senderAccount.payGold(GoldType.ruby, totalGold);
        updateAccountPort.updateAccount(senderAccount);
        //TODO unlock account

        //TODO lock account item
        for (AccountItem accountItem : accountItems) {
            accountItem.delivery(requestItemIdAmountMap.get(accountItem.getId()));
            updateAccountItemPort.updateAccountItem(accountItem);
        }
        //TODO unlock account item

        registerDeliveryPort.createDelivery(Delivery.builder()
                .sender(senderAccount)
                .receiver(Account.builder().id(command.getReceiverId()).build())
                .items(deliveryItems)
                .ruby(totalGold)
                .date(new Date())
                .state(DeliveryState.wait)
                .build());
    }
}
