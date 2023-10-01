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
        AccountJpaEntity entity = repository.findById(id).orElseThrow(EntityNotFoundException::new);
        return mapper.mapToDomainEntity(entity);
    }

    @Override
    public void changeAccountGold(Account account) {
        AccountJpaEntity entity = mapper.mapToJpaEntity(account);
        repository.save(entity);
    }
}
