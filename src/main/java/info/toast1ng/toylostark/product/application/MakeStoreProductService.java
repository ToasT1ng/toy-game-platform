package info.toast1ng.toylostark.product.application;

import info.toast1ng.toylostark.product.application.port.in.MakeProductCommand;
import info.toast1ng.toylostark.product.application.port.in.MakeStoreProductUseCase;
import info.toast1ng.toylostark.product.application.port.out.MakeStoreProductPort;
import info.toast1ng.toylostark.product.domain.StoreProduct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MakeStoreProductService implements MakeStoreProductUseCase {
    private final MakeStoreProductPort port;

    @Override
    public void makeProduct(MakeProductCommand command) {
        port.makeStoreProduct(StoreProduct.builder()
                .name(command.getName())
                .category(command.getCategory())
                .price(command.getPrice())
                .build());
    }
}
