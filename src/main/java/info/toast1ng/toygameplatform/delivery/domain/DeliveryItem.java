package info.toast1ng.toygameplatform.delivery.domain;

import info.toast1ng.toygameplatform.product.domain.StoreProduct;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder
@ToString
@Getter
public class DeliveryItem {
    private long id;
    private StoreProduct product;
    private int amount;
}
