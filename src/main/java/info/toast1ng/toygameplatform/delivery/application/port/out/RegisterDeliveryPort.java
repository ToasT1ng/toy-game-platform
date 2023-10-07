package info.toast1ng.toygameplatform.delivery.application.port.out;

import info.toast1ng.toygameplatform.delivery.domain.Delivery;

public interface RegisterDeliveryPort {
    void createDelivery(Delivery delivery);
}
