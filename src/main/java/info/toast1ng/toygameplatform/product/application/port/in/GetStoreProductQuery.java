package info.toast1ng.toygameplatform.product.application.port.in;

import info.toast1ng.toygameplatform.product.domain.StoreProduct;
import org.springframework.data.domain.Page;

import java.util.List;

public interface GetStoreProductQuery {
    List<StoreProduct> listStoreProducts();
    Page<StoreProduct> listStoreProducts(ListStoreProductsCommand command);
    StoreProduct loadStoreProduct(long id);

}
