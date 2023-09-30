package info.toast1ng.toylostark.charge.domain;

import info.toast1ng.toylostark.account.domain.Account;
import info.toast1ng.toylostark.common.domain.Gold;
import info.toast1ng.toylostark.common.domain.Money;

import java.util.Date;

public class Order {
    private long id;
    private Account user;
    private Date date;
    private Money price;
    private Gold diamond;
}
