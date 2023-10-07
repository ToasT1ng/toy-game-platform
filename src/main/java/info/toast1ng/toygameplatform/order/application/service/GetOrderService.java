package info.toast1ng.toygameplatform.order.application.service;

import info.toast1ng.toygameplatform.order.application.port.in.GetOrderQuery;
import info.toast1ng.toygameplatform.order.application.port.out.LoadOrderPort;
import info.toast1ng.toygameplatform.order.domain.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class GetOrderService implements GetOrderQuery {
    private final LoadOrderPort loadOrderPort;

    @Override
    public List<Order> getOrders(long userId) {
        return loadOrderPort.loadOrders(userId);
    }
}
