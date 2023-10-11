package info.toast1ng.toygameplatform.delivery.application.port.out;

import info.toast1ng.toygameplatform.delivery.domain.Delivery;

import java.util.List;

public interface LoadDeliveryPort {
    Delivery loadDelivery(long id);
    Delivery loadWaitDelivery(long id);

    List<Delivery> loadReceivedDelivery(long userId);
    List<Delivery> loadReceivedDelivery(String username);
    List<Delivery> loadSendDelivery(long userId);
    List<Delivery> loadSendDelivery(String username);
}
