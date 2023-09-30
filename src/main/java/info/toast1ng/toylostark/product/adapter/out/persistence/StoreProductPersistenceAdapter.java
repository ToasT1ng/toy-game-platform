package info.toast1ng.toylostark.product.adapter.out.persistence;

import info.toast1ng.toylostark.common.PersistenceAdapter;
import info.toast1ng.toylostark.product.application.port.out.DeleteStoreProductPort;
import info.toast1ng.toylostark.product.application.port.out.LoadStoreProductPort;
import info.toast1ng.toylostark.product.application.port.out.RegisterStoreProductPort;
import info.toast1ng.toylostark.product.domain.StoreProduct;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@PersistenceAdapter
public class StoreProductPersistenceAdapter implements RegisterStoreProductPort, LoadStoreProductPort, DeleteStoreProductPort {
    private final StoreProductMapper mapper;
    private final SpringDataStoreProductRepository repository;


    @Override
    public void createStoreProduct(StoreProduct storeProduct) {
        repository.save(mapper.mapToJpaEntity(storeProduct));
    }

    @Override
    public List<StoreProduct> listStoreProducts() {
        return mapper.mapToDomainEntity(repository.findAll());
    }

    @Override
    public StoreProduct loadStoreProduct(long id) {
        return mapper.mapToDomainEntity(repository.findById(id));
    }

    @Override
    public void deleteStoreProduct(long id) {
        repository.deleteStoreProduct(id);
    }
}
