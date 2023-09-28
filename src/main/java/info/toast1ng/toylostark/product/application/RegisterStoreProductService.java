package info.toast1ng.toylostark.product.application;

import info.toast1ng.toylostark.product.application.port.in.RegisterProductCommand;
import info.toast1ng.toylostark.product.application.port.in.RegisterStoreProductUseCase;
import info.toast1ng.toylostark.product.application.port.out.RegisterStoreProductPort;
import info.toast1ng.toylostark.product.domain.StoreProduct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@RequiredArgsConstructor
@Service
public class RegisterStoreProductService implements RegisterStoreProductUseCase {
    private final RegisterStoreProductPort port;

    @Override
    public void registerProduct(RegisterProductCommand command) {
        port.createStoreProduct(StoreProduct.builder()
                .name(command.getName())
                .category(command.getCategory())
                .price(command.getPrice())
                .build());
    }
}
