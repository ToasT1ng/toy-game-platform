package info.toast1ng.toylostark.product.application.port.out;

import info.toast1ng.toylostark.product.domain.StoreProduct;

public interface RegisterStoreProductPort {
    void createStoreProduct(StoreProduct storeProduct);
}
