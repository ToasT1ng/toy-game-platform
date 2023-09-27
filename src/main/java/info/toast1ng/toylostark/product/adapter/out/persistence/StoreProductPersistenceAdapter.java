package info.toast1ng.toylostark.product.adapter.out.persistence;

import info.toast1ng.toylostark.common.PersistenceAdapter;
import info.toast1ng.toylostark.product.application.port.out.GetStoreProductPort;
import info.toast1ng.toylostark.product.application.port.out.MakeStoreProductPort;
import info.toast1ng.toylostark.product.domain.StoreProduct;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@PersistenceAdapter
public class StoreProductPersistenceAdapter implements MakeStoreProductPort, GetStoreProductPort {
    private final StoreProductMapper mapper;
    private final SpringDataStoreProductRepository repository;


    @Override
    public void makeStoreProduct(StoreProduct storeProduct) {
        repository.save(mapper.mapToJpaEntity(storeProduct));
    }

    @Override
    public List<StoreProduct> getStoreProduct() {
        return mapper.mapToDomainObject(repository.findAll());
    }

    @Override
    public StoreProduct getStoreProduct(long id) {
        return mapper.mapToDomainObject(repository.getReferenceById(id));
    }
}
