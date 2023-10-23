package info.toast1ng.toygameplatform.delivery.adapter.out;

import info.toast1ng.toygameplatform.account.adapter.out.persistence.AccountJpaEntity;
import info.toast1ng.toygameplatform.account.domain.Account;
import info.toast1ng.toygameplatform.common.adapter.out.persistence.BasicMapper;
import info.toast1ng.toygameplatform.common.domain.Gold;
import info.toast1ng.toygameplatform.delivery.domain.Delivery;
import info.toast1ng.toygameplatform.delivery.domain.DeliveryItem;
import info.toast1ng.toygameplatform.product.adapter.out.persistence.StoreProductJpaEntity;
import info.toast1ng.toygameplatform.product.domain.Image;
import info.toast1ng.toygameplatform.product.domain.StoreProduct;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DeliveryMapper implements BasicMapper<DeliveryJpaEntity, Delivery> {

    @Override
    public DeliveryJpaEntity mapToJpaEntity(Delivery delivery) {
        DeliveryJpaEntity jpaEntity = DeliveryJpaEntity.builder()
                .id(delivery.getId())
                .receiver(AccountJpaEntity.builder()
                        .id(delivery.getReceiver().getId())
                        .username(delivery.getReceiver().getUsername())
                        .build())
                .sender(AccountJpaEntity.builder()
                        .id(delivery.getSender().getId())
                        .username(delivery.getSender().getUsername())
                        .build())
                .date(delivery.getDate())
                .ruby(delivery.getRuby().getAmount())
                .state(delivery.getState())
                .build();
        jpaEntity.setItems(mapToItemJpaEntity(delivery.getItems(), jpaEntity));
        return jpaEntity;
    }

    public DeliveryItemJpaEntity mapToItemJpaEntity(DeliveryJpaEntity deliveryJpaEntity, DeliveryItem deliveryItem) {
        return DeliveryItemJpaEntity.builder()
                .id(deliveryItem.getId())
                .delivery(deliveryJpaEntity)
                .product(StoreProductJpaEntity.builder()
                        .id(deliveryItem.getProduct().getId())
                        .build())
                .amount(deliveryItem.getAmount())
                .build();
    }

    public List<DeliveryItemJpaEntity> mapToItemJpaEntity(List<DeliveryItem> domainEntities, DeliveryJpaEntity jpaEntity) {
        List<DeliveryItemJpaEntity> jpaEntities = new ArrayList<>();
        for (DeliveryItem domainEntity : domainEntities) {
            jpaEntities.add(mapToItemJpaEntity(jpaEntity, domainEntity));
        }
        return jpaEntities;
    }

    @Override
    public Delivery mapToDomainEntity(DeliveryJpaEntity deliveryJpaEntity) {
        return Delivery.builder()
                .id(deliveryJpaEntity.getId())
                .items(mapToItemDomainEntity(deliveryJpaEntity.getItems()))
                .sender(Account.builder()
                        .id(deliveryJpaEntity.getSender().getId())
                        .username(deliveryJpaEntity.getSender().getUsername())
                        .build())
                .receiver(Account.builder()
                        .id(deliveryJpaEntity.getReceiver().getId())
                        .username(deliveryJpaEntity.getReceiver().getUsername())
                        .build())
                .date(deliveryJpaEntity.getDate())
                .ruby(new Gold(deliveryJpaEntity.getRuby()))
                .state(deliveryJpaEntity.getState())
                .build();
    }

    public List<Delivery> mapToDomainEntity(List<DeliveryJpaEntity> jpaEntities) {
        List<Delivery> domainEntities = new ArrayList<>();
        for (DeliveryJpaEntity jpaEntity : jpaEntities) {
            domainEntities.add(mapToDomainEntity(jpaEntity));
        }
        return domainEntities;

    }

    public DeliveryItem mapToItemDomainEntity(DeliveryItemJpaEntity deliveryItemJpaEntity) {
        return DeliveryItem.builder()
                .id(deliveryItemJpaEntity.getId())
                .product(StoreProduct.builder()
                        .id(deliveryItemJpaEntity.getProduct().getId())
                        .name(deliveryItemJpaEntity.getProduct().getName())
                        .image(new Image(deliveryItemJpaEntity.getProduct().getImageUrl()))
                        .build())
                .amount(deliveryItemJpaEntity.getAmount())
                .build();
    }

    public List<DeliveryItem> mapToItemDomainEntity(List<DeliveryItemJpaEntity> jpaEntities) {
        List<DeliveryItem> domainEntities = new ArrayList<>();
        for (DeliveryItemJpaEntity jpaEntity : jpaEntities) {
            domainEntities.add(mapToItemDomainEntity(jpaEntity));
        }
        return domainEntities;
    }

}
