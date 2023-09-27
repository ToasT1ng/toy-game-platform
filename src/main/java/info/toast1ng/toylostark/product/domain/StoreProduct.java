package info.toast1ng.toylostark.product.domain;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class StoreProduct {
    private long id;
    private String name;
    private String category;
    private int price;
}
