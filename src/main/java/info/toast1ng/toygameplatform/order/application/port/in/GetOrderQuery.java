package info.toast1ng.toygameplatform.order.application.port.in;

import info.toast1ng.toygameplatform.order.domain.Order;

import java.util.List;

public interface GetOrderQuery {
    List<Order> getOrders(long userId);
}
