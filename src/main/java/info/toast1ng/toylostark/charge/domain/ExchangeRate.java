package info.toast1ng.toylostark.charge.domain;

import info.toast1ng.toylostark.common.domain.Gold;
import info.toast1ng.toylostark.common.domain.Money;
import lombok.Getter;


@Getter
public class ExchangeRate {
    private long id;
    private Money price;
    private Gold diamond;
    private int bonus;

    public ExchangeRate(Money price, Gold diamond) {
        this.price = price;
        this.diamond = diamond;
        this.bonus = diamond.getAmount() - (price.getAmount() / 100);
    }

}
