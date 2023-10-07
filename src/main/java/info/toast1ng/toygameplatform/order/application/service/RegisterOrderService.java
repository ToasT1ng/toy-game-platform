package info.toast1ng.toygameplatform.order.application.service;

import info.toast1ng.toygameplatform.account.application.port.out.LoadAccountPort;
import info.toast1ng.toygameplatform.account.application.port.out.LoadAccountItemPort;
import info.toast1ng.toygameplatform.account.application.port.out.UpdateAccountPort;
import info.toast1ng.toygameplatform.account.application.port.out.UpdateAccountItemPort;
import info.toast1ng.toygameplatform.account.domain.Account;
import info.toast1ng.toygameplatform.account.domain.AccountItem;
import info.toast1ng.toygameplatform.common.domain.Gold;
import info.toast1ng.toygameplatform.order.application.port.in.RegisterOrderUseCase;
import info.toast1ng.toygameplatform.order.application.port.out.RegisterOrderPort;
import info.toast1ng.toygameplatform.order.domain.Order;
import info.toast1ng.toygameplatform.product.application.port.out.LoadStoreProductPort;
import info.toast1ng.toygameplatform.product.domain.StoreProduct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;

@Transactional
@RequiredArgsConstructor
@Service
public class RegisterOrderService implements RegisterOrderUseCase {
    private final LoadAccountPort loadAccountPort;
    private final UpdateAccountPort updateAccountPort;
    private final LoadStoreProductPort loadStoreProductPort;
    private final RegisterOrderPort registerOrderPort;
    private final LoadAccountItemPort loadAccountItemPort;
    private final UpdateAccountItemPort updateAccountItemPort;

    @Override
    public void registerOrder(RegisterOrderCommand registerOrderCommand) throws Exception {
        Account account = loadAccountPort.loadAccount(registerOrderCommand.getUserId());
        StoreProduct storeProduct = loadStoreProductPort.loadStoreProduct(registerOrderCommand.getProductId());

        Gold totalGold = storeProduct.getPrice();
        totalGold.multiplyGold(registerOrderCommand.getAmount());

        //TODO 오류 처리 매끄럽게
        if (!account.isAbleToPay(storeProduct.getType(), totalGold)) {
            throw new Exception("money not ready");
        }

        Order order = Order.builder()
                .user(account)
                .product(storeProduct)
                .productAmount(registerOrderCommand.getAmount())
                .price(totalGold)
                .goldType(storeProduct.getType())
                .date(new Date())
                .build();
        registerOrderPort.registerOrder(order);

        //TODO lock account
        account.payGold(storeProduct.getType(), totalGold);
        updateAccountPort.updateAccount(account);
        //TODO unlock account

        //TODO lock accountItem
        AccountItem accountItem = loadAccountItemPort.loadAccountItem(account.getId(), storeProduct.getId());
        accountItem.accept(registerOrderCommand.getAmount());
        updateAccountItemPort.updateAccountItem(accountItem);
        //TODO unlock accountItem
    }
}
