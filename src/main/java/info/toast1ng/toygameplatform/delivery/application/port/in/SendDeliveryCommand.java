package info.toast1ng.toygameplatform.delivery.application.port.in;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
public class SendDeliveryCommand {
    private long senderId;
    private String receiverUsername;
    private List<DeliveryItemInfo> items;
    private int ruby = 0;

    @NoArgsConstructor
    @Data
    public static class DeliveryItemInfo {
//        private long itemId;
        private long productId;
        private int amount;
    }
}
