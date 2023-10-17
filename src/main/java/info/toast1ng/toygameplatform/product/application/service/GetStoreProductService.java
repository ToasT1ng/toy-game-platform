package info.toast1ng.toygameplatform.product.application.service;

import info.toast1ng.toygameplatform.common.GoldType;
import info.toast1ng.toygameplatform.product.application.port.in.GetStoreProductQuery;
import info.toast1ng.toygameplatform.product.application.port.out.LoadStoreProductPort;
import info.toast1ng.toygameplatform.product.domain.StoreProduct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@RequiredArgsConstructor
@Service
public class GetStoreProductService implements GetStoreProductQuery {
    private final LoadStoreProductPort port;

    @Override
    public List<StoreProduct> listStoreProducts() {
        return port.listStoreProducts();
    }

    @Override
    public List<StoreProduct> listStoreProducts(GoldType goldType) {
        return port.listStoreProducts(goldType);
    }

    @Override
    public StoreProduct loadStoreProduct(long id) {
        return port.loadStoreProduct(id);
    }
}
