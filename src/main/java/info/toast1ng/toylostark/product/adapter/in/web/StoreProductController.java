package info.toast1ng.toylostark.product.adapter.in.web;

import info.toast1ng.toylostark.product.application.port.in.GetStoreProductUseCase;
import info.toast1ng.toylostark.product.application.port.in.MakeProductCommand;
import info.toast1ng.toylostark.product.application.port.in.MakeStoreProductUseCase;
import info.toast1ng.toylostark.product.domain.StoreProduct;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class StoreProductController {
    private final MakeStoreProductUseCase makeStoreProductUseCase;
    private final GetStoreProductUseCase getStoreProductUseCase;

    @PostMapping("/store-product")
    public String makeStoreProduct(MakeStoreProductVO vo) {
        System.out.println(vo.toString());
        makeStoreProductUseCase.makeProduct(MakeProductCommand.builder()
                .name(vo.getName())
                .category(vo.getCategory().name())
                .price(vo.getPrice())
                .build());
        return "success";
    }

    @GetMapping("/store-product")
    public List<StoreProduct> getStoreProduct() {
        return getStoreProductUseCase.getStoreProduct();
    }
}
