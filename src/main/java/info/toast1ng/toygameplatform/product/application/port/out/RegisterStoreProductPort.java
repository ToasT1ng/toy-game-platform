package info.toast1ng.toygameplatform.product.application.port.out;

import info.toast1ng.toygameplatform.product.domain.StoreProduct;

public interface RegisterStoreProductPort {
    long createStoreProduct(StoreProduct storeProduct);
}
