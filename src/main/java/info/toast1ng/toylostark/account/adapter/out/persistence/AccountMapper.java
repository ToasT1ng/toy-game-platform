package info.toast1ng.toylostark.account.adapter.out.persistence;

import info.toast1ng.toylostark.account.domain.Account;
import info.toast1ng.toylostark.common.domain.Gold;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class AccountMapper {
    public Account mapToDomainEntity(AccountJpaEntity entity) {
        return Account.builder()
                .id(entity.getId())
                .username(entity.getUsername())
                .password(entity.getPassword())
                .grade(entity.getGrade())
                .golds(Account.Golds.builder()
                        .ruby(new Gold(entity.getRuby()))
                        .diamond(new Gold(entity.getDiamond()))
                        .build())
                .lastLogin(new Date())
                .build();
    }
}
