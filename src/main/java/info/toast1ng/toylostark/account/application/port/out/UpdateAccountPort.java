package info.toast1ng.toylostark.account.application.port.out;

import info.toast1ng.toylostark.account.domain.Account;

public interface UpdateAccountPort {
    void changeAccountGold(Account account);
}
