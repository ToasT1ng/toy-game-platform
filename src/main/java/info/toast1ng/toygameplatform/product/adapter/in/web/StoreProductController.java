package info.toast1ng.toygameplatform.product.adapter.in.web;

import info.toast1ng.toygameplatform.common.WebAdapter;
import info.toast1ng.toygameplatform.product.application.port.in.DeleteStoreProductUseCase;
import info.toast1ng.toygameplatform.product.application.port.in.GetStoreProductQuery;
import info.toast1ng.toygameplatform.product.application.port.in.RegisterProductCommand;
import info.toast1ng.toygameplatform.product.application.port.in.RegisterStoreProductUseCase;
import info.toast1ng.toygameplatform.product.domain.StoreProduct;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@WebAdapter
@RequiredArgsConstructor
@RestController
public class StoreProductController {
    private final RegisterStoreProductUseCase registerStoreProductUseCase;
    private final GetStoreProductQuery getStoreProductQuery;
    private final DeleteStoreProductUseCase deleteStoreProductUseCase;

    @PostMapping("/store-products")
    public ResponseStoreProduct registerStoreProduct(@Valid RegisterStoreProductVO vo) {
        long id = registerStoreProductUseCase.registerProduct(RegisterProductCommand.of(vo));
        return ResponseStoreProduct.of(id);
    }

    @GetMapping("/store-products")
    public List<StoreProduct> listStoreProducts() {
        return getStoreProductQuery.listStoreProducts();
    }

    @DeleteMapping("/store-products/{id}")
    public ResponseEntity<?> deleteStoreProduct(@PathVariable long id) {
        deleteStoreProductUseCase.deleteStoreProduct(id);
        return new ResponseEntity<>(ResponseStoreProduct.of(id), HttpStatus.OK);
    }

    @PutMapping("/store-products/{id}")
    public ResponseEntity<?> updateStoreProduct(@PathVariable long id) {
        deleteStoreProductUseCase.deleteStoreProduct(id);
        return new ResponseEntity<>(ResponseStoreProduct.of(id), HttpStatus.OK);
    }
}
