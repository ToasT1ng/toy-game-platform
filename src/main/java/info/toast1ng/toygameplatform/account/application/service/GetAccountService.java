package info.toast1ng.toygameplatform.account.application.service;

import info.toast1ng.toygameplatform.account.application.port.in.GetAccountQuery;
import info.toast1ng.toygameplatform.account.application.port.out.LoadAccountPort;
import info.toast1ng.toygameplatform.account.domain.Account;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class GetAccountService implements GetAccountQuery {
    private final LoadAccountPort port;

    @Override
    public Account getAccount(long id) {
        return port.loadAccount(id);
    }

    @Override
    public Account.Golds getGolds(long id) {
        return port.loadAccount(id).getGolds();
    }
}
