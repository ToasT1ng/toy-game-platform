package info.toast1ng.toygameplatform.order.adapter.out.persistence;

import info.toast1ng.toygameplatform.account.domain.Account;
import info.toast1ng.toygameplatform.common.adapter.out.persistence.BasicMapper;
import info.toast1ng.toygameplatform.common.domain.Gold;
import info.toast1ng.toygameplatform.order.domain.Order;
import info.toast1ng.toygameplatform.product.adapter.out.persistence.StoreProductJpaEntity;
import info.toast1ng.toygameplatform.product.domain.StoreProduct;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderMapper implements BasicMapper<OrderJpaEntity, Order> {
    @Override
    public OrderJpaEntity mapToJpaEntity(Order domainEntity) {
        return OrderJpaEntity.builder()
                .id(domainEntity.getId())
                .userId(domainEntity.getUser().getId())
                .product(StoreProductJpaEntity.builder()
                        .id(domainEntity.getProduct().getId())
                        .build())
                .productAmount(domainEntity.getProductAmount())
                .date(domainEntity.getDate())
                .goldType(domainEntity.getGoldType())
                .price(domainEntity.getPrice().getAmount())
                .build();
    }

    @Override
    public Order mapToDomainEntity(OrderJpaEntity jpaEntity) {
        return Order.builder()
                .id(jpaEntity.getId())
                .user(Account.builder()
                        .id(jpaEntity.getUserId())
                        .build())
                .product(StoreProduct.builder()
                        .id(jpaEntity.getProduct().getId())
                        .name(jpaEntity.getProduct().getName())
                        .build())
                .productAmount(jpaEntity.getProductAmount())
                .date(jpaEntity.getDate())
                .goldType(jpaEntity.getGoldType())
                .price(new Gold(jpaEntity.getPrice()))
                .build();
    }

    public List<Order> mapToDomainEntity(List<OrderJpaEntity> jpaEntities) {
        List<Order> domainEntities = new ArrayList<>();
        for (OrderJpaEntity jpaEntity : jpaEntities) {
            domainEntities.add(mapToDomainEntity(jpaEntity));
        }
        return domainEntities;
    }
}
