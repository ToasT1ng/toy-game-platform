package info.toast1ng.toygameplatform.order.domain;

import info.toast1ng.toygameplatform.account.domain.Account;
import info.toast1ng.toygameplatform.common.GoldType;
import info.toast1ng.toygameplatform.common.domain.Gold;
import info.toast1ng.toygameplatform.product.domain.StoreProduct;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.Date;

@ToString
@Builder
@Getter
public class Order {
    private long id;
    private Account user;
    private Date date;
    private StoreProduct product;
    private int productAmount;
    private GoldType goldType;
    private Gold price;
}
