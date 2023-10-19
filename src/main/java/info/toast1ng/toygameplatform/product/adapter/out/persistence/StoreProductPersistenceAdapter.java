package info.toast1ng.toygameplatform.product.adapter.out.persistence;

import info.toast1ng.toygameplatform.common.GoldType;
import info.toast1ng.toygameplatform.common.PersistenceAdapter;
import info.toast1ng.toygameplatform.product.application.port.out.DeleteStoreProductPort;
import info.toast1ng.toygameplatform.product.application.port.out.LoadStoreProductPort;
import info.toast1ng.toygameplatform.product.application.port.out.RegisterStoreProductPort;
import info.toast1ng.toygameplatform.product.application.port.out.UpdateStoreProductPort;
import info.toast1ng.toygameplatform.product.domain.StoreProduct;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

@RequiredArgsConstructor
@PersistenceAdapter
public class StoreProductPersistenceAdapter implements RegisterStoreProductPort, LoadStoreProductPort, DeleteStoreProductPort, UpdateStoreProductPort {
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
    public Page<StoreProduct> listStoreProducts(String nameKeyword, Pageable pageable) {
        return mapper.mapToPagingDomainEntity(repository.findAllByNameContains(nameKeyword, pageable));
    }

    @Override
    public Page<StoreProduct> listStoreProducts(String nameKeyword, GoldType goldType, Pageable pageable) {
        return mapper.mapToPagingDomainEntity(repository.findAllByNameContainsAndGoldType(nameKeyword, goldType, pageable));
    }

    @Override
    public StoreProduct loadStoreProduct(long id) {
        return mapper.mapToDomainEntity(repository.findById(id));
    }

    @Override
    public void deleteStoreProduct(long id) {
        repository.deleteStoreProduct(id);
    }

    @Override
    public void updateStoreProduct(StoreProduct storeProduct) {
        repository.save(mapper.mapToJpaEntity(storeProduct));
    }
}
