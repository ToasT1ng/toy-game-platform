package info.toast1ng.toygameplatform.order.application.port.out;

import info.toast1ng.toygameplatform.order.domain.Order;

import java.util.List;

public interface LoadOrderPort {
    List<Order> loadOrders(long userId);
}
