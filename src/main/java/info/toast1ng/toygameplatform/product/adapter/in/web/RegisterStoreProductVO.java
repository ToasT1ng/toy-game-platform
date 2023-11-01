package info.toast1ng.toygameplatform.product.adapter.in.web;

import info.toast1ng.toygameplatform.common.GoldType;
import info.toast1ng.toygameplatform.common.validation.ValidEnum;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@Data
public class RegisterStoreProductVO {
    public enum ProductCategory {clothes, pet, item}

    @NotNull
    @NotBlank
    private String name;

    @ValidEnum(enumClass = ProductCategory.class)
    private String category;

    @ValidEnum(enumClass = GoldType.class)
    private String type;

    @NotNull
    @Min(1)
    private int price;

    @NotNull
    private String imageUrl;
}
