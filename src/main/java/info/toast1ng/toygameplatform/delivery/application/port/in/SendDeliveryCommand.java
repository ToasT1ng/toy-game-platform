package info.toast1ng.toygameplatform.delivery.application.port.in;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@NoArgsConstructor
@Data
public class SendDeliveryCommand {
    @NotNull
    @Min(0)
    private long senderId;

    @NotNull
    @NotBlank
    private String receiverUsername;

    private List<DeliveryItemInfo> items;
    private int ruby = 0;

    @NoArgsConstructor
    @Data
    public static class DeliveryItemInfo {
        @NotNull
        private long productId;

        @NotNull
        @Min(1)
        private int amount;
    }
}
