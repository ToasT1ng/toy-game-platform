package info.toast1ng.toygameplatform.charge.application.port.in;

import info.toast1ng.toygameplatform.common.domain.Gold;
import info.toast1ng.toygameplatform.common.domain.Money;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ApproveCommand {
    private PaymentType paymentType;
    private String pgToken;
    private String tid;
    private String orderId;
    private Money price;
    private Gold diamond;
    private long userId;
}
