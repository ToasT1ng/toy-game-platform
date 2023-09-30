package info.toast1ng.toylostark.account.adapter.out.persistence;

import info.toast1ng.toylostark.account.application.port.out.LoadAccountPort;
import info.toast1ng.toylostark.account.domain.Account;
import info.toast1ng.toylostark.common.PersistenceAdapter;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@RequiredArgsConstructor
@PersistenceAdapter
public class AccountPersistenceAdapter implements LoadAccountPort {
    private final AccountMapper mapper;

    @Override
    public Account loadAccount(long id) {
        AccountJpaEntity entity = AccountJpaEntity.builder()
                .id(0)
                .username("jane")
                .password("1234")
                .grade(Account.AccountGrade.admin)
                .diamond(1125)
                .ruby(115)
                .lastLogin(new Date())
                .build();

        return mapper.mapToDomainEntity(entity);
    }
}
