package info.toast1ng.toylostark.product.application.port.out;

import info.toast1ng.toylostark.product.domain.StoreProduct;

import java.util.List;

public interface GetStoreProductPort {
    List<StoreProduct> getStoreProduct();
    StoreProduct getStoreProduct(long id);
}
