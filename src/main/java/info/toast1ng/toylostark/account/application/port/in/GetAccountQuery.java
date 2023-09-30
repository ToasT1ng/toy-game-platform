package info.toast1ng.toylostark.account.application.port.in;

import info.toast1ng.toylostark.account.domain.Account;

public interface GetAccountQuery {
    Account getAccount(long id);
    Account.Golds getGolds(long id);
}
