package info.toast1ng.toygameplatform.delivery.domain;

import info.toast1ng.toygameplatform.account.domain.Account;
import info.toast1ng.toygameplatform.common.domain.Gold;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.*;

@Builder
@ToString
@Getter
public class Delivery {
    private long id;
    private List<DeliveryItem> items;
    private Account sender;
    private Account receiver;
    private Date date;
    private Gold ruby;
    private DeliveryState state;

    public void updateDeliveryState(DeliveryState state) {
        this.state = state;
    }

    public Map<Long, Integer> getItemProductMap() {
        Map<Long, Integer> result = new HashMap<>();
        for (DeliveryItem item : items) {
            result.put(item.getProduct().getId(), item.getAmount());
        }
        return result;
    }
}
