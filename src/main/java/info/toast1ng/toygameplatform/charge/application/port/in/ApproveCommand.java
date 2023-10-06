package info.toast1ng.toygameplatform.charge.application.port.in;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ApproveCommand {
    private String pgToken;
    private long orderId;
}
