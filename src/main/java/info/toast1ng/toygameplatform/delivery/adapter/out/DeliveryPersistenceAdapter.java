package info.toast1ng.toygameplatform.delivery.adapter.out;

import info.toast1ng.toygameplatform.common.PersistenceAdapter;
import info.toast1ng.toygameplatform.delivery.application.port.out.LoadDeliveryPort;
import info.toast1ng.toygameplatform.delivery.application.port.out.RegisterDeliveryPort;
import info.toast1ng.toygameplatform.delivery.application.port.out.UpdateDeliveryPort;
import info.toast1ng.toygameplatform.delivery.domain.Delivery;
import info.toast1ng.toygameplatform.delivery.domain.DeliveryState;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RequiredArgsConstructor
@PersistenceAdapter
public class DeliveryPersistenceAdapter implements LoadDeliveryPort, RegisterDeliveryPort, UpdateDeliveryPort {
    private final DeliveryMapper mapper;
    private final SpringDataDeliveryRepository repository;

    @Override
    public Delivery loadDelivery(long id) {
        return mapper.mapToDomainEntity(repository.findById(id).orElseThrow(EntityNotFoundException::new));
    }

    @Override
    public Delivery loadWaitDelivery(long id) {
        return mapper.mapToDomainEntity(repository.findByIdAndState(id, DeliveryState.wait).orElseThrow(EntityNotFoundException::new));
    }

    @Override
    public List<Delivery> loadReceivedDelivery(long userId) {
        return mapper.mapToDomainEntity(repository.findAllByReceiverIdOrderByDateDesc(userId, PageRequest.of(0, 10)));
    }

    @Override
    public List<Delivery> loadReceivedDelivery(String username) {
        return mapper.mapToDomainEntity(repository.findAllByReceiverUsernameOrderByDateDesc(username, PageRequest.of(0, 10)));
    }

    @Override
    public List<Delivery> loadSendDelivery(long userId) {
        return mapper.mapToDomainEntity(repository.findAllBySenderIdOrderByDateDesc(userId, PageRequest.of(0, 10)));
    }

    @Override
    public List<Delivery> loadSendDelivery(String username) {
        return mapper.mapToDomainEntity(repository.findAllBySenderUsernameOrderByDateDesc(username, PageRequest.of(0, 10)));
    }

    @Override
    public void createDelivery(Delivery delivery) {
        repository.save(mapper.mapToJpaEntity(delivery));
    }

    @Override
    public void updateDelivery(Delivery delivery) {
        repository.save(mapper.mapToJpaEntity(delivery));
    }
}
