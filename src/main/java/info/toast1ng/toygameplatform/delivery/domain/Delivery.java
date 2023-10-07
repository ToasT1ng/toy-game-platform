package info.toast1ng.toygameplatform.delivery.domain;

import info.toast1ng.toygameplatform.account.domain.Account;
import info.toast1ng.toygameplatform.common.domain.Gold;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.Date;
import java.util.List;

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
}
