package info.toast1ng.toygameplatform.charge.adapter.out.persistence;

import info.toast1ng.toygameplatform.charge.application.port.out.LoadChargeOrderPort;
import info.toast1ng.toygameplatform.charge.application.port.out.RegisterChargeOrderPort;
import info.toast1ng.toygameplatform.charge.domain.ChargeOrder;
import info.toast1ng.toygameplatform.common.PersistenceAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;

import java.util.Date;
import java.util.List;

@RequiredArgsConstructor
@PersistenceAdapter
public class ChargeOrderPersistenceAdapter implements RegisterChargeOrderPort, LoadChargeOrderPort {
    private final SpringDataChargeOrderRepository repository;
    private final ChargeOrderMapper mapper;

    @Override
    public long registerChargeOrder(ChargeOrder domainEntity) {
        ChargeOrderJpaEntity entity = mapper.mapToJpaEntity(domainEntity);
        return repository.save(entity).getId();
    }

    @Override
    public List<ChargeOrder> loadChargeOrder(long userId, int limitNumber) {
        List<ChargeOrderJpaEntity> entities = repository.findAllByUserIdOrderByDateDesc(userId, PageRequest.of(0, limitNumber));
        return mapper.mapToDomainEntity(entities);
    }

    @Override
    public List<ChargeOrder> loadChargeOrder(long userId, Date startDate, Date endDate) {
        List<ChargeOrderJpaEntity> entities = repository.findAllByUserIdAndDateAfterAndDateBeforeOrderByDateDesc(userId, startDate, endDate, PageRequest.of(0, 5));
        return mapper.mapToDomainEntity(entities);
    }
}
