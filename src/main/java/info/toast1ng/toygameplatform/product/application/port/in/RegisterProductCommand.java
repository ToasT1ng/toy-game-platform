package info.toast1ng.toygameplatform.product.application.port.in;

import info.toast1ng.toygameplatform.product.domain.StoreProduct;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class RegisterProductCommand {
    private String name;
    private String category;
    private StoreProduct.GoldType type;
    private int price;
}
