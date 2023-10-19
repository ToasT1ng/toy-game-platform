package info.toast1ng.toygameplatform.product.domain;

import info.toast1ng.toygameplatform.common.GoldType;
import info.toast1ng.toygameplatform.common.domain.Gold;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder
@ToString
@Getter
public class StoreProduct {
    private long id;
    private String name;
    private String category;
    private GoldType type;
    private Gold price;
    private Image image;

    public void changeDetails(String name, Gold price, Image image) {
        this.name = name;
        this.price = price;
        this.image = image;
    }
}
