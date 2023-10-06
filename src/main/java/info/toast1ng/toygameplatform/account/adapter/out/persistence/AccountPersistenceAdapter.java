package info.toast1ng.toygameplatform.account.adapter.out.persistence;

import info.toast1ng.toygameplatform.account.application.port.out.LoadAccountPort;
import info.toast1ng.toygameplatform.account.application.port.out.LoadAccountProductPort;
import info.toast1ng.toygameplatform.account.application.port.out.UpdateAccountPort;
import info.toast1ng.toygameplatform.account.application.port.out.UpdateAccountProductPort;
import info.toast1ng.toygameplatform.account.domain.Account;
import info.toast1ng.toygameplatform.account.domain.AccountProduct;
import info.toast1ng.toygameplatform.common.PersistenceAdapter;
import info.toast1ng.toygameplatform.product.domain.StoreProduct;
import lombok.RequiredArgsConstructor;

import javax.persistence.EntityNotFoundException;

@RequiredArgsConstructor
@PersistenceAdapter
public class AccountPersistenceAdapter implements LoadAccountPort, UpdateAccountPort, LoadAccountProductPort, UpdateAccountProductPort {
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

    @Override
    public AccountProduct loadAccountProduct(long userId, long productId) {
        return AccountProduct.builder()
                .account(Account.builder()
                        .id(userId)
                        .build())
                .storeProduct(StoreProduct.builder()
                        .id(productId)
                        .build())
                .amount(1)
                .build();
    }

    @Override
    public void changeAccountProductAmount(AccountProduct accountProduct) {
        System.out.println("CHANGE ==> " + accountProduct.toString());
    }
}
