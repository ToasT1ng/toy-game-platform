package info.toast1ng.toygameplatform.product.application.port.in;

import info.toast1ng.toygameplatform.common.GoldType;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class RegisterProductCommand {
    private String name;
    private String category;
    private GoldType type;
    private int price;
}
