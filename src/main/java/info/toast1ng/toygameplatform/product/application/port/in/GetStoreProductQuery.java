package info.toast1ng.toygameplatform.product.application.port.in;

import info.toast1ng.toygameplatform.common.GoldType;
import info.toast1ng.toygameplatform.product.domain.StoreProduct;

import java.util.List;

public interface GetStoreProductQuery {
    List<StoreProduct> listStoreProducts();
    List<StoreProduct> listStoreProducts(GoldType goldType);
    StoreProduct loadStoreProduct(long id);
}
