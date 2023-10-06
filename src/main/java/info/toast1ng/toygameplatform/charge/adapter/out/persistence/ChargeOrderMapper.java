package info.toast1ng.toygameplatform.charge.adapter.out.persistence;

import info.toast1ng.toygameplatform.account.domain.Account;
import info.toast1ng.toygameplatform.charge.domain.ChargeOrder;
import info.toast1ng.toygameplatform.common.adapter.out.persistence.BasicMapper;
import info.toast1ng.toygameplatform.common.domain.Gold;
import info.toast1ng.toygameplatform.common.domain.Money;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ChargeOrderMapper implements BasicMapper<ChargeOrderJpaEntity, ChargeOrder> {
    @Override
    public ChargeOrderJpaEntity mapToJpaEntity(ChargeOrder domainEntity) {
        return ChargeOrderJpaEntity.builder()
                .id(domainEntity.getId())
                .userId(domainEntity.getUser().getId())
                .date(domainEntity.getDate())
                .diamond(domainEntity.getDiamond().getAmount())
                .price(domainEntity.getPrice().getAmount())
                .paymentType(domainEntity.getPaymentType())
                .build();
    }

    @Override
    public ChargeOrder mapToDomainEntity(ChargeOrderJpaEntity jpaEntity) {
        return ChargeOrder.builder()
                .id(jpaEntity.getId())
                .user(Account.builder()
                        .id(jpaEntity.getUserId())
                        .build())
                .date(jpaEntity.getDate())
                .diamond(new Gold(jpaEntity.getDiamond()))
                .price(new Money(jpaEntity.getPrice()))
                .paymentType(jpaEntity.getPaymentType())
                .build();
    }

    public List<ChargeOrder> mapToDomainEntity(List<ChargeOrderJpaEntity> jpaEntities) {
        List<ChargeOrder> domainEntities = new ArrayList<>();
        for (ChargeOrderJpaEntity jpaEntity : jpaEntities) {
            domainEntities.add(mapToDomainEntity(jpaEntity));
        }
        return domainEntities;
    }
}
