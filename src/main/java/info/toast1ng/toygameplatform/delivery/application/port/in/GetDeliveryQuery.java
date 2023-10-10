package info.toast1ng.toygameplatform.delivery.application.port.in;

import info.toast1ng.toygameplatform.delivery.domain.Delivery;

import java.util.List;

public interface GetDeliveryQuery {
    List<Delivery> getReceivedDeliveries(long userId);
    List<Delivery> getReceivedDeliveries(String username);
    List<Delivery> getSendDeliveries(long userId);
    List<Delivery> getSendDeliveries(String username);
}
