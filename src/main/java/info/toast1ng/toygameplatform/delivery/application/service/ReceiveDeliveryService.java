package info.toast1ng.toygameplatform.delivery.application.service;

import info.toast1ng.toygameplatform.account.application.port.out.LoadAccountItemPort;
import info.toast1ng.toygameplatform.account.application.port.out.LoadAccountPort;
import info.toast1ng.toygameplatform.account.application.port.out.UpdateAccountItemPort;
import info.toast1ng.toygameplatform.account.application.port.out.UpdateAccountPort;
import info.toast1ng.toygameplatform.account.domain.Account;
import info.toast1ng.toygameplatform.account.domain.AccountItem;
import info.toast1ng.toygameplatform.delivery.application.port.in.ReceiveDeliveryUseCase;
import info.toast1ng.toygameplatform.delivery.application.port.out.LoadDeliveryPort;
import info.toast1ng.toygameplatform.delivery.application.port.out.UpdateDeliveryPort;
import info.toast1ng.toygameplatform.delivery.domain.Delivery;
import info.toast1ng.toygameplatform.delivery.domain.DeliveryState;
import info.toast1ng.toygameplatform.product.domain.StoreProduct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Transactional
@Service
public class ReceiveDeliveryService implements ReceiveDeliveryUseCase {
    private final LoadDeliveryPort loadDeliveryPort;
    private final LoadAccountPort loadAccountPort;
    private final UpdateAccountPort updateAccountPort;
    private final LoadAccountItemPort loadAccountItemPort;
    private final UpdateAccountItemPort updateAccountItemPort;
    private final UpdateDeliveryPort updateDeliveryPort;

    @Override
    public void acceptDelivery(long id) {
        Delivery delivery = loadDeliveryPort.loadWaitDelivery(id);

        Account receiver = loadAccountPort.loadAccount(delivery.getReceiver().getId());
        if (!receiver.getGrade().equals(Account.AccountGrade.admin)) {
            addRuby(delivery, receiver);
        }
        addAccountItems(delivery, receiver);

        delivery.updateDeliveryState(DeliveryState.accept);
        updateDeliveryPort.updateDelivery(delivery);
    }


    private void addRuby(Delivery delivery, Account account) {
        //TODO lock account
        account.addRuby(delivery.getRuby());
        updateAccountPort.updateAccount(account);
        //TODO unlock account
    }

    private void addAccountItems(Delivery delivery, Account account) {
        //TODO lock account item
        Map<Long, Integer> itemProductMap = delivery.getItemProductMap();
        List<AccountItem> receiverItems = loadAccountItemPort.loadAccountItemsByProductIds(account.getId(), itemProductMap.keySet());
        for (AccountItem item : receiverItems) {
            item.accept(itemProductMap.get(item.getProduct().getId()));
            updateAccountItemPort.updateAccountItem(item);
            itemProductMap.remove(item.getProduct().getId());
        }
        for (long productId : itemProductMap.keySet()) {
            AccountItem accountItem = AccountItem.builder()
                    .product(StoreProduct.builder().id(productId).build())
                    .account(account)
                    .amount(itemProductMap.get(productId))
                    .build();
            updateAccountItemPort.updateAccountItem(accountItem);
        }
        //TODO unlock account item
    }

    @Override
    public void cancelDelivery(long id) {
        Delivery delivery = loadDeliveryPort.loadWaitDelivery(id);

        Account sender = loadAccountPort.loadAccount(delivery.getSender().getId());
        if (!sender.getGrade().equals(Account.AccountGrade.admin)) {
            addRuby(delivery, sender);
        }
        addAccountItems(delivery, sender);

        delivery.updateDeliveryState(DeliveryState.cancel);
        updateDeliveryPort.updateDelivery(delivery);
    }

    @Override
    public void rejectDelivery(long id) {
        Delivery delivery = loadDeliveryPort.loadWaitDelivery(id);

        Account sender = loadAccountPort.loadAccount(delivery.getSender().getId());
        if (!sender.getGrade().equals(Account.AccountGrade.admin)) {
            addRuby(delivery, sender);
        }
        addAccountItems(delivery, sender);

        delivery.updateDeliveryState(DeliveryState.reject);
        updateDeliveryPort.updateDelivery(delivery);
    }
}
