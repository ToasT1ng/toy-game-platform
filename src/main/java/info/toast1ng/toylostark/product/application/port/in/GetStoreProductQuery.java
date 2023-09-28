package info.toast1ng.toylostark.product.application.port.in;

import info.toast1ng.toylostark.product.domain.StoreProduct;

import java.util.List;

public interface GetStoreProductQuery {
    List<StoreProduct> listStoreProducts();
    StoreProduct loadStoreProduct(long id);
}
