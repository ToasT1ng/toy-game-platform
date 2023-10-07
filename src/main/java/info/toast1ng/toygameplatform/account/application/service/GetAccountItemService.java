package info.toast1ng.toygameplatform.account.application.service;

import info.toast1ng.toygameplatform.account.application.port.in.GetAccountItemQuery;
import info.toast1ng.toygameplatform.account.application.port.out.LoadAccountItemPort;
import info.toast1ng.toygameplatform.account.domain.AccountItem;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class GetAccountItemService implements GetAccountItemQuery {
    private final LoadAccountItemPort port;

    @Override
    public List<AccountItem> getAccountItems(long userId) {
        return port.loadAccountItems(userId);
    }
}
