package info.toast1ng.toygameplatform.charge.application.port.in;

import info.toast1ng.toygameplatform.common.domain.Gold;
import info.toast1ng.toygameplatform.common.domain.Money;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ReadyCommand {
    private long userId;
    private Money price;
    private Gold diamond;
    private PaymentType paymentType;
}
