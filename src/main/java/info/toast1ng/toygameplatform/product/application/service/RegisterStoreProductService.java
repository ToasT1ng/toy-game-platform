package info.toast1ng.toygameplatform.product.application.service;

import info.toast1ng.toygameplatform.common.domain.Gold;
import info.toast1ng.toygameplatform.product.application.port.in.RegisterProductCommand;
import info.toast1ng.toygameplatform.product.application.port.in.RegisterStoreProductUseCase;
import info.toast1ng.toygameplatform.product.application.port.out.RegisterStoreProductPort;
import info.toast1ng.toygameplatform.product.domain.Image;
import info.toast1ng.toygameplatform.product.domain.StoreProduct;
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
                .type(command.getType())
                .price(new Gold(command.getPrice()))
                .image(new Image(command.getImageUrl()))
                .build());
    }
}
