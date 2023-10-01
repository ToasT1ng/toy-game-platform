package info.toast1ng.toygameplatform.charge.domain;

import info.toast1ng.toygameplatform.common.domain.Gold;
import info.toast1ng.toygameplatform.common.domain.Money;
import lombok.Getter;


@Getter
public class ExchangeRate {
    private long id;
    private Money price;
    private Gold diamond;
    private int bonus;

    public ExchangeRate(long id, Money price, Gold diamond) {
        this.id = id;
        this.price = price;
        this.diamond = diamond;
        this.bonus = diamond.getAmount() - (price.getAmount() / 100);
    }

}
