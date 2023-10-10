package info.toast1ng.toygameplatform.account.application.service;

import info.toast1ng.toygameplatform.account.application.port.in.GetAccountItemQuery;
import info.toast1ng.toygameplatform.account.application.port.out.LoadAccountItemPort;
import info.toast1ng.toygameplatform.account.application.port.out.LoadAccountPort;
import info.toast1ng.toygameplatform.account.domain.AccountItem;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class GetAccountItemService implements GetAccountItemQuery {
    private final LoadAccountItemPort loadAccountItemPort;

    @Override
    public List<AccountItem> getAccountItems(long userId) {
        return loadAccountItemPort.loadAccountItems(userId);
    }

    @Override
    public List<AccountItem> getAccountItems(String username) {
        return loadAccountItemPort.loadAccountItems(username);
    }
}
