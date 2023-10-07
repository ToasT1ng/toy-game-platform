package info.toast1ng.toygameplatform.account.adapter.out.persistence;

import info.toast1ng.toygameplatform.account.application.port.out.LoadAccountItemPort;
import info.toast1ng.toygameplatform.account.application.port.out.UpdateAccountItemPort;
import info.toast1ng.toygameplatform.account.domain.AccountItem;
import info.toast1ng.toygameplatform.common.PersistenceAdapter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@PersistenceAdapter
public class AccountItemPersistenceAdapter implements LoadAccountItemPort, UpdateAccountItemPort {
    private final AccountItemMapper mapper;
    private final SpringDataAccountItemRepository repository;

    @Override
    public AccountItem loadAccountItem(long userId, long productId) {
        return mapper.mapToDomainEntity(repository.findByUserIdAndProductId(userId, productId)
                .orElse(new AccountItemJpaEntity(userId, productId)));
    }

    @Override
    public List<AccountItem> loadAccountItems(long userId) {
        return mapper.mapToDomainEntity(repository.findAllByUserId(userId));
    }

    @Override
    public void updateAccountItem(AccountItem accountItem) {
        repository.save(mapper.mapToJpaEntity(accountItem));
    }
}
