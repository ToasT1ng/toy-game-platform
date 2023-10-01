package info.toast1ng.toygameplatform.product.application.port.out;

import info.toast1ng.toygameplatform.product.domain.StoreProduct;

import java.util.List;

public interface LoadStoreProductPort {
    List<StoreProduct> listStoreProducts();
    StoreProduct loadStoreProduct(long id);
}
