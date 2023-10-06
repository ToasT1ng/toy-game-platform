package info.toast1ng.toygameplatform.product.adapter.in.web;

import info.toast1ng.toygameplatform.common.WebAdapter;
import info.toast1ng.toygameplatform.product.application.port.in.DeleteStoreProductUseCase;
import info.toast1ng.toygameplatform.product.application.port.in.GetStoreProductQuery;
import info.toast1ng.toygameplatform.product.application.port.in.RegisterProductCommand;
import info.toast1ng.toygameplatform.product.application.port.in.RegisterStoreProductUseCase;
import info.toast1ng.toygameplatform.product.domain.StoreProduct;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@WebAdapter
@RequiredArgsConstructor
@RestController
public class StoreProductController {
    private final RegisterStoreProductUseCase registerStoreProductUseCase;
    private final GetStoreProductQuery getStoreProductQuery;
    private final DeleteStoreProductUseCase deleteStoreProductUseCase;

    @PostMapping("/store-products")
    public String registerStoreProduct(RegisterStoreProductVO vo) {
        registerStoreProductUseCase.registerProduct(RegisterProductCommand.builder()
                .name(vo.getName())
                .category(vo.getCategory().name())
                .type(vo.getType())
                .price(vo.getPrice())
                .build());
        return "success";
    }

    @GetMapping("/store-products")
    public List<StoreProduct> listStoreProducts() {
        return getStoreProductQuery.listStoreProducts();
    }

    @DeleteMapping("/store-products/{id}")
    public String deleteStoreProduct(@PathVariable long id) {
        deleteStoreProductUseCase.deleteStoreProduct(id);
        return "success";
    }
}
