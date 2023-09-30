package info.toast1ng.toylostark.product.domain;

import info.toast1ng.toylostark.common.domain.Gold;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder
@ToString
@Getter
public class StoreProduct {
    public enum GoldType {diamond, ruby}
    private long id;
    private String name;
    private String category;
    private GoldType type;
    private Gold price;
}
