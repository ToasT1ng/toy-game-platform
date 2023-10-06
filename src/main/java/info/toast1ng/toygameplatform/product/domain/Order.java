package info.toast1ng.toygameplatform.product.domain;

import info.toast1ng.toygameplatform.account.domain.Account;
import info.toast1ng.toygameplatform.common.domain.Gold;

import java.util.Date;
import java.util.List;

public class Order {
    private long id;
    private Account user;
    private Date date;
    private List<OrderItem> items;
    private StoreProduct.GoldType goldType;
    private Gold totalPrice;
}
