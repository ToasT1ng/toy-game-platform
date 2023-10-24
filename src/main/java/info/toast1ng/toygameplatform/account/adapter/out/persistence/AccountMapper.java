package info.toast1ng.toygameplatform.account.adapter.out.persistence;

import info.toast1ng.toygameplatform.account.domain.Account;
import info.toast1ng.toygameplatform.common.adapter.out.persistence.BasicMapper;
import info.toast1ng.toygameplatform.common.domain.Gold;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class AccountMapper implements BasicMapper<AccountJpaEntity, Account> {
    public Account mapToDomainEntity(AccountJpaEntity entity) {
        return Account.builder()
                .id(entity.getId())
                .username(entity.getUsername())
                .password(entity.getPassword())
                .mailAddress(entity.getMailAddress())
                .nickname(entity.getNickname())
                .grade(entity.getGrade())
                .golds(Account.Golds.builder()
                        .ruby(new Gold(entity.getRuby()))
                        .diamond(new Gold(entity.getDiamond()))
                        .build())
                .lastLogin(new Date())
                .build();
    }

    public AccountJpaEntity mapToJpaEntity(Account domain) {
        return AccountJpaEntity.builder()
                .id(domain.getId())
                .username(domain.getUsername())
                .password(domain.getPassword())
                .mailAddress(domain.getMailAddress())
                .nickname(domain.getNickname())
                .grade(domain.getGrade())
                .ruby(domain.getGolds().getRuby().getAmount())
                .diamond(domain.getGolds().getDiamond().getAmount())
                .lastLogin(domain.getLastLogin())
                .build();
    }
}
