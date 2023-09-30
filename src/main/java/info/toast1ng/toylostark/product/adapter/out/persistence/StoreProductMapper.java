package info.toast1ng.toylostark.product.adapter.out.persistence;

import info.toast1ng.toylostark.common.domain.Gold;
import info.toast1ng.toylostark.product.domain.StoreProduct;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StoreProductMapper {
    public StoreProductJpaEntity mapToJpaEntity(StoreProduct storeProduct) {
        return StoreProductJpaEntity.builder()
                .category(storeProduct.getCategory())
                .name(storeProduct.getName())
                .type(storeProduct.getType())
                .price(storeProduct.getPrice().getAmount())
                .build();
    }

    public StoreProduct mapToDomainEntity(StoreProductJpaEntity entity) {
        return StoreProduct.builder()
                .id(entity.getId())
                .category(entity.getCategory())
                .name(entity.getName())
                .type(entity.getType())
                .price(new Gold(entity.getPrice()))
                .build();
    }

    public List<StoreProduct> mapToDomainEntity(List<StoreProductJpaEntity> entities) {
        List<StoreProduct> list = new ArrayList<>();
        for (StoreProductJpaEntity entity : entities) {
            list.add(mapToDomainEntity(entity));
        }
        return list;
    }
}
