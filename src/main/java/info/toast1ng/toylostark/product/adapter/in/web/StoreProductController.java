package info.toast1ng.toylostark.product.adapter.in.web;

import info.toast1ng.toylostark.product.application.port.in.GetStoreProductQuery;
import info.toast1ng.toylostark.product.application.port.in.RegisterProductCommand;
import info.toast1ng.toylostark.product.application.port.in.RegisterStoreProductUseCase;
import info.toast1ng.toylostark.product.domain.StoreProduct;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class StoreProductController {
    private final RegisterStoreProductUseCase registerStoreProductUseCase;
    private final GetStoreProductQuery getStoreProductQuery;

    @PostMapping("/store-product")
    public String registerStoreProduct(RegisterStoreProductVO vo) {
        registerStoreProductUseCase.registerProduct(RegisterProductCommand.builder()
                .name(vo.getName())
                .category(vo.getCategory().name())
                .price(vo.getPrice())
                .build());
        return "success";
    }

    @GetMapping("/store-product")
    public List<StoreProduct> listStoreProducts() {
        return getStoreProductQuery.listStoreProducts();
    }
}
