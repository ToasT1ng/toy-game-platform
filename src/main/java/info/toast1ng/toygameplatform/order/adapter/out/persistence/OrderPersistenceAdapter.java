package info.toast1ng.toygameplatform.order.adapter.out.persistence;

import info.toast1ng.toygameplatform.common.PersistenceAdapter;
import info.toast1ng.toygameplatform.order.application.port.out.RegisterOrderPort;
import info.toast1ng.toygameplatform.order.domain.Order;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@PersistenceAdapter
public class OrderPersistenceAdapter implements RegisterOrderPort {
    @Override
    public void registerOrder(Order order) {
        System.out.println("ORDER ==> " + order.toString());
    }
}
