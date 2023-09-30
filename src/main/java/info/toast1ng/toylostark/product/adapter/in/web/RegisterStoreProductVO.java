package info.toast1ng.toylostark.product.adapter.in.web;

import info.toast1ng.toylostark.product.domain.StoreProduct;
import lombok.*;

@NoArgsConstructor
@Data
public class RegisterStoreProductVO {
    enum ProductCategory {clothes, pet}
    private String name;
    private ProductCategory category;
    private StoreProduct.GoldType type;
    private int price;
}
