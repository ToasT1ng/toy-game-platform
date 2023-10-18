package info.toast1ng.toygameplatform.product.application.port.in;

import info.toast1ng.toygameplatform.common.GoldType;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.domain.PageRequest;

@AllArgsConstructor
@Data
public class ListStoreProductsCommand {
    private String keyword;
    private GoldType goldType;
    private PageRequest pageRequest;
}
