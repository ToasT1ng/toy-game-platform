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
    private StoreProduct product;
    private int amount;

    public void accept(int amount) {
        this.amount += amount;
    }

    public void delivery(int amount) {
        this.amount -= amount;
    }

    public boolean isAbleToDelivery(int amount) {
        return this.amount >= amount;
    }
}
