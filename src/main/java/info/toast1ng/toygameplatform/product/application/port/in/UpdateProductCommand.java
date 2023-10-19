package info.toast1ng.toygameplatform.product.application.port.in;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UpdateProductCommand {
    private long id;
    private String name;
    private int price;
    private String imageUrl;
}
