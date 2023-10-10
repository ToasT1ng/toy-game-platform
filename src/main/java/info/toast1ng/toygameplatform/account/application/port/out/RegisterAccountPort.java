package info.toast1ng.toygameplatform.account.application.port.out;

import info.toast1ng.toygameplatform.account.domain.Account;

public interface RegisterAccountPort {
    void createAccount(Account account);
}
