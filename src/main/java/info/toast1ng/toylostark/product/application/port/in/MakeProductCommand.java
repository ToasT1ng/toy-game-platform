package info.toast1ng.toylostark.product.application.port.in;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class MakeProductCommand {
    private String name;
    private String category;
    private int price;
}
