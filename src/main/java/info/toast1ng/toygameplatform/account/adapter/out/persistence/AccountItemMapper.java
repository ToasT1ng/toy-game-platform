package info.toast1ng.toygameplatform.account.adapter.out.persistence;

import info.toast1ng.toygameplatform.account.domain.Account;
import info.toast1ng.toygameplatform.account.domain.AccountItem;
import info.toast1ng.toygameplatform.common.adapter.out.persistence.BasicMapper;
import info.toast1ng.toygameplatform.product.adapter.out.persistence.StoreProductJpaEntity;
import info.toast1ng.toygameplatform.product.domain.StoreProduct;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountItemMapper implements BasicMapper<AccountItemJpaEntity, AccountItem> {
    @Override
    public AccountItemJpaEntity mapToJpaEntity(AccountItem domainEntity) {
        return AccountItemJpaEntity.builder()
                .id(domainEntity.getId())
                .userId(domainEntity.getAccount().getId())
                .product(StoreProductJpaEntity.builder()
                        .id(domainEntity.getStoreProduct().getId())
                        .build())
                .amount(domainEntity.getAmount())
                .build();
    }

    @Override
    public AccountItem mapToDomainEntity(AccountItemJpaEntity jpaEntity) {
        return AccountItem.builder()
                .id(jpaEntity.getId())
                .account(Account.builder()
                        .id(jpaEntity.getUserId())
                        .build())
                .storeProduct(StoreProduct.builder()
                        .id(jpaEntity.getProduct().getId())
                        .name(jpaEntity.getProduct().getName())
                        .build())
                .amount(jpaEntity.getAmount())
                .build();
    }

    public List<AccountItem> mapToDomainEntity(List<AccountItemJpaEntity> jpaEntities) {
        List<AccountItem> domainEntities = new ArrayList<>();
        for (AccountItemJpaEntity jpaEntity : jpaEntities) {
            domainEntities.add(mapToDomainEntity(jpaEntity));
        }
        return domainEntities;
    }
}
