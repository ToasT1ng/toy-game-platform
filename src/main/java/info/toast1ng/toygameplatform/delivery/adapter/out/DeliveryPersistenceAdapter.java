package info.toast1ng.toygameplatform.delivery.adapter.out;

import info.toast1ng.toygameplatform.common.PersistenceAdapter;
import info.toast1ng.toygameplatform.delivery.application.port.out.LoadDeliveryPort;
import info.toast1ng.toygameplatform.delivery.application.port.out.RegisterDeliveryPort;
import info.toast1ng.toygameplatform.delivery.domain.Delivery;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;

import java.util.List;

@RequiredArgsConstructor
@PersistenceAdapter
public class DeliveryPersistenceAdapter implements LoadDeliveryPort, RegisterDeliveryPort {
    private final DeliveryMapper mapper;
    private final SpringDataDeliveryRepository repository;

    @Override
    public List<Delivery> loadReceivedDelivery(long userId) {
        return mapper.mapToDomainEntity(repository.findAllByReceiverIdOrderByDateDesc(userId, PageRequest.of(0, 10)));
    }

    @Override
    public List<Delivery> loadSendDelivery(long userId) {
        return mapper.mapToDomainEntity(repository.findAllBySenderIdOrderByDateDesc(userId, PageRequest.of(0, 10)));
    }

    @Override
    public void createDelivery(Delivery delivery) {
        repository.save(mapper.mapToJpaEntity(delivery));
    }
}
