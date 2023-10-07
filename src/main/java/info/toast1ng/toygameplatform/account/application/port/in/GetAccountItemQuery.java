package info.toast1ng.toygameplatform.account.application.port.in;

import info.toast1ng.toygameplatform.account.domain.AccountItem;

import java.util.List;

public interface GetAccountItemQuery {
    List<AccountItem> getAccountItems(long userId);
}
