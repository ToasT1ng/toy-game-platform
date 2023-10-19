package info.toast1ng.toygameplatform.product.application.service;

import info.toast1ng.toygameplatform.common.domain.Gold;
import info.toast1ng.toygameplatform.product.application.port.in.UpdateProductCommand;
import info.toast1ng.toygameplatform.product.application.port.in.UpdateStoreProductUseCase;
import info.toast1ng.toygameplatform.product.application.port.out.LoadStoreProductPort;
import info.toast1ng.toygameplatform.product.application.port.out.UpdateStoreProductPort;
import info.toast1ng.toygameplatform.product.domain.Image;
import info.toast1ng.toygameplatform.product.domain.StoreProduct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UpdateStoreProductService implements UpdateStoreProductUseCase {
    private final LoadStoreProductPort loadStoreProductPort;
    private final UpdateStoreProductPort updateStoreProductPort;

    @Override
    public void updateStoreProduct(UpdateProductCommand command) {
        StoreProduct storeProduct = loadStoreProductPort.loadStoreProduct(command.getId());
        storeProduct.changeDetails(command.getName(), new Gold(command.getPrice()), new Image(command.getImageUrl()));
        updateStoreProductPort.updateStoreProduct(storeProduct);
    }
}
