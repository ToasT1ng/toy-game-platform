package info.toast1ng.toylostark.charge.domain;

import info.toast1ng.toylostark.common.domain.Gold;
import info.toast1ng.toylostark.common.domain.Money;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class FixedExchangeRates {
    private List<ExchangeRate> list = new ArrayList<>();

    public FixedExchangeRates() {
        list.add(new ExchangeRate(new Money(1000), new Gold(10)));
        list.add(new ExchangeRate(new Money(5000), new Gold(60)));
        list.add(new ExchangeRate(new Money(10000), new Gold(115)));
        list.add(new ExchangeRate(new Money(20000), new Gold(220)));
    }
}
