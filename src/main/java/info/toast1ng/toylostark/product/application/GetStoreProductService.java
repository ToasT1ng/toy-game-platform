package info.toast1ng.toylostark.product.application;

import info.toast1ng.toylostark.product.application.port.in.GetStoreProductUseCase;
import info.toast1ng.toylostark.product.application.port.out.GetStoreProductPort;
import info.toast1ng.toylostark.product.domain.StoreProduct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class GetStoreProductService implements GetStoreProductUseCase {
    private final GetStoreProductPort port;

    @Override
    public List<StoreProduct> getStoreProduct() {
        return port.getStoreProduct();
    }

    @Override
    public StoreProduct getStoreProduct(long id) {
        return port.getStoreProduct(id);
    }
}
