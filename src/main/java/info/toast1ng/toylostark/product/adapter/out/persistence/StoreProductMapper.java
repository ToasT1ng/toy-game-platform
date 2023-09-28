package info.toast1ng.toylostark.product.adapter.out.persistence;

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
                .price(storeProduct.getPrice())
                .build();
    }

    public StoreProduct mapToDomainObject(StoreProductJpaEntity entity) {
        return StoreProduct.builder()
                .id(entity.getId())
                .category(entity.getCategory())
                .name(entity.getName())
                .price(entity.getPrice())
                .build();
    }

    public List<StoreProduct> mapToDomainObject(List<StoreProductJpaEntity> entities) {
        List<StoreProduct> list = new ArrayList<>();
        for (StoreProductJpaEntity entity : entities) {
            list.add(mapToDomainObject(entity));
        }
        return list;
    }
}
