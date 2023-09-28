package info.toast1ng.toylostark.product.application.port.out;

import info.toast1ng.toylostark.product.domain.StoreProduct;

import java.util.List;

public interface LoadStoreProductPort {
    List<StoreProduct> listStoreProducts();
    StoreProduct loadStoreProduct(long id);
}
