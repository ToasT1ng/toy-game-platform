package info.toast1ng.toylostark.product.application.port.service;

import info.toast1ng.toylostark.product.application.port.in.GetStoreProductQuery;
import info.toast1ng.toylostark.product.application.port.out.LoadStoreProductPort;
import info.toast1ng.toylostark.product.domain.StoreProduct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@RequiredArgsConstructor
@Service
public class GetStoreProductService implements GetStoreProductQuery {
    private final LoadStoreProductPort port;

    @Override
    public List<StoreProduct> listStoreProducts() {
        return port.listStoreProducts();
    }

    @Override
    public StoreProduct loadStoreProduct(long id) {
        return port.loadStoreProduct(id);
    }
}
