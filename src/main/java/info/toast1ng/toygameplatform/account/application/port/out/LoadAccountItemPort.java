package info.toast1ng.toygameplatform.account.application.port.out;

import info.toast1ng.toygameplatform.account.domain.AccountItem;

import java.util.List;

public interface LoadAccountItemPort {
    AccountItem loadAccountItem(long userId, long productId);
    List<AccountItem> loadAccountItems(long userId);
}
