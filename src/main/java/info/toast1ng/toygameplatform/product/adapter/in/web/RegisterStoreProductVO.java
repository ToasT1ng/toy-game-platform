package info.toast1ng.toygameplatform.product.adapter.in.web;

import info.toast1ng.toygameplatform.common.GoldType;
import lombok.*;

@NoArgsConstructor
@Data
public class RegisterStoreProductVO {
    enum ProductCategory {clothes, pet, item}
    private String name;
    private ProductCategory category;
    private GoldType type;
    private int price;
    private String imageUrl;
}
