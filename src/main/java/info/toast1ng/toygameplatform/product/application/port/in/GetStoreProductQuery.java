package info.toast1ng.toygameplatform.product.application.port.in;

import info.toast1ng.toygameplatform.product.domain.StoreProduct;

import java.util.List;

public interface GetStoreProductQuery {
    List<StoreProduct> listStoreProducts();
    StoreProduct loadStoreProduct(long id);
}
