package info.toast1ng.toygameplatform.account.domain;

import info.toast1ng.toygameplatform.product.domain.StoreProduct;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@Builder
public class AccountItem {
    private long id;
    private Account account;
    private StoreProduct storeProduct;
    private int amount;

    public void addAmount(int amount) {
        this.amount += amount;
    }
}
