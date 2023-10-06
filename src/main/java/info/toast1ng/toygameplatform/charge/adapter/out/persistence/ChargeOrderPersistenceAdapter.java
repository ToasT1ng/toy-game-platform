package info.toast1ng.toygameplatform.charge.adapter.out.persistence;

import info.toast1ng.toygameplatform.charge.application.port.out.LoadChargeOrderPort;
import info.toast1ng.toygameplatform.charge.application.port.out.RegisterChargeOrderPort;
import info.toast1ng.toygameplatform.charge.application.port.out.UpdateChargeOrderStatePort;
import info.toast1ng.toygameplatform.charge.domain.ChargeOrder;
import info.toast1ng.toygameplatform.common.PersistenceAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RequiredArgsConstructor
@PersistenceAdapter
public class ChargeOrderPersistenceAdapter implements RegisterChargeOrderPort, LoadChargeOrderPort, UpdateChargeOrderStatePort {
    private final SpringDataChargeOrderRepository repository;
    private final ChargeOrderMapper mapper;

    @Override
    public long registerChargeOrder(ChargeOrder domainEntity) {
        ChargeOrderJpaEntity entity = mapper.mapToJpaEntity(domainEntity);
        return repository.save(entity).getId();
    }

    @Override
    public List<ChargeOrder> loadChargeOrders(long userId, int limitNumber) {
        List<ChargeOrderJpaEntity> entities = repository.findAllByUserIdOrderByDateDesc(userId, PageRequest.of(0, limitNumber));
        return mapper.mapToDomainEntity(entities);
    }

    @Override
    public ChargeOrder loadChargeOrder(long orderId) {
        return mapper.mapToDomainEntity(repository.findById(orderId).orElseThrow(EntityNotFoundException::new));
    }

    @Override
    public void updateChargeOrderStatePort(long orderId) {
        repository.updateApprovedStateToTrueByOrderId(orderId);
    }
}
