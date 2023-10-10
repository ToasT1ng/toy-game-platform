package info.toast1ng.toygameplatform.account.application.port.in;

import info.toast1ng.toygameplatform.account.domain.Account;

public interface GetAccountQuery {
    Account getAccount(long id);
    Account getAccount(String username);
    Account.Golds getGolds(long id);
}
