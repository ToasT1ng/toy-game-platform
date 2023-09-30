package info.toast1ng.toylostark.account.application.port.out;

import info.toast1ng.toylostark.account.domain.Account;

public interface LoadAccountPort {
    Account loadAccount(long id);
}
