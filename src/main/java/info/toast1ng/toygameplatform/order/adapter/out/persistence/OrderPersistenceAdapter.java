package info.toast1ng.toygameplatform.order.adapter.out.persistence;

import info.toast1ng.toygameplatform.common.PersistenceAdapter;
import info.toast1ng.toygameplatform.order.application.port.out.LoadOrderPort;
import info.toast1ng.toygameplatform.order.application.port.out.RegisterOrderPort;
import info.toast1ng.toygameplatform.order.domain.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;

import java.util.List;

@RequiredArgsConstructor
@PersistenceAdapter
public class OrderPersistenceAdapter implements RegisterOrderPort, LoadOrderPort {
    private final SpringDataOrderRepository repository;
    private final OrderMapper mapper;

    @Override
    public void registerOrder(Order order) {
        repository.save(mapper.mapToJpaEntity(order));
    }

    @Override
    public List<Order> loadOrders(long userId) {
        return mapper.mapToDomainEntity(repository.findAllByUserIdOrderByDateDesc(userId, PageRequest.of(0, 5)));
    }

    @Override
    public List<Order> loadOrders(String username) {
        return null;
    }
}
