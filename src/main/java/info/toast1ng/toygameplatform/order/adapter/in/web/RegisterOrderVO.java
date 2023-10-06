package info.toast1ng.toygameplatform.order.adapter.in.web;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RegisterOrderVO {
    private long userId;
    private long productId;
    private int amount;
}
