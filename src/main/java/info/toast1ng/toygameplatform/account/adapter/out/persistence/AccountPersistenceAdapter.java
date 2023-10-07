package info.toast1ng.toygameplatform.account.adapter.out.persistence;

import info.toast1ng.toygameplatform.account.application.port.out.LoadAccountPort;
import info.toast1ng.toygameplatform.account.application.port.out.UpdateAccountPort;
import info.toast1ng.toygameplatform.account.domain.Account;
import info.toast1ng.toygameplatform.common.PersistenceAdapter;
import lombok.RequiredArgsConstructor;

import javax.persistence.EntityNotFoundException;

@RequiredArgsConstructor
@PersistenceAdapter
public class AccountPersistenceAdapter implements LoadAccountPort, UpdateAccountPort {
    private final SpringDataAccountRepository repository;
    private final AccountMapper mapper;

    @Override
    public Account loadAccount(long id) {
        return mapper.mapToDomainEntity(repository.findById(id).orElseThrow(EntityNotFoundException::new));
    }

    @Override
    public void updateAccount(Account account) {
        repository.save(mapper.mapToJpaEntity(account));
    }
}
