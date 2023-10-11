package info.toast1ng.toygameplatform.account.application.port.out;

import info.toast1ng.toygameplatform.account.domain.AccountItem;

import java.util.List;
import java.util.Set;

public interface LoadAccountItemPort {
    AccountItem loadAccountItem(long userId, long productId);
    List<AccountItem> loadAccountItems(long userId);
    List<AccountItem> loadAccountItems(long userId, Set<Long> itemIds);
    List<AccountItem> loadAccountItems(String username);
    List<AccountItem> loadAccountItemsByProductIds(long userId, Set<Long> productIds);
}
