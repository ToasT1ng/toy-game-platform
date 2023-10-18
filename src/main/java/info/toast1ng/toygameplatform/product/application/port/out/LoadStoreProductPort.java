package info.toast1ng.toygameplatform.product.application.port.out;

import info.toast1ng.toygameplatform.common.GoldType;
import info.toast1ng.toygameplatform.product.domain.StoreProduct;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface LoadStoreProductPort {
    List<StoreProduct> listStoreProducts();
    Page<StoreProduct> listStoreProducts(String nameKeyword, Pageable pageable);
    Page<StoreProduct> listStoreProducts(String nameKeyword, GoldType goldType, Pageable pageable);
    StoreProduct loadStoreProduct(long id);

}
