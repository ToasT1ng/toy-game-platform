package info.toast1ng.toygameplatform.order.application.service;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
@Builder
public class RegisterOrderCommand {
    private long userId;
    private long productId;
    private int amount;
}
