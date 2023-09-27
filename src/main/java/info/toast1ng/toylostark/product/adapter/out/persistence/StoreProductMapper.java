package info.toast1ng.toylostark.product.adapter.out.persistence;

import info.toast1ng.toylostark.product.domain.StoreProduct;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StoreProductMapper {
    int count = 2;
    public StoreProductJpaEntity mapToJpaEntity(StoreProduct storeProduct) {
        count++;
        return StoreProductJpaEntity.builder()
                .id(count)
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
