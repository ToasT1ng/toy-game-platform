package info.toast1ng.toygameplatform.order.application.port.out;

import info.toast1ng.toygameplatform.order.domain.Order;

public interface RegisterOrderPort {
    void registerOrder(Order order);
}
