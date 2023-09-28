package info.toast1ng.toylostark.product.adapter.in.web;

import lombok.*;

@NoArgsConstructor
@Data
public class RegisterStoreProductVO {
    enum ProductCategory {clothes, pet}
    private String name;
    private ProductCategory category;
    private int price;
}