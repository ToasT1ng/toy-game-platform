package info.toast1ng.toylostark.charge.adapter.out.persistence;

import info.toast1ng.toylostark.charge.application.port.out.LoadChargeOrderPort;
import info.toast1ng.toylostark.charge.application.port.out.RegisterChargeOrderPort;
import info.toast1ng.toylostark.charge.domain.ChargeOrder;
import info.toast1ng.toylostark.common.PersistenceAdapter;
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
    public void registerChargeOrder(ChargeOrder domainEntity) {
        System.out.println(domainEntity.toString());
        ChargeOrderJpaEntity entity = mapper.mapToJpaEntity(domainEntity);
        System.out.println(entity.toString());
        repository.save(entity);
    }

    @Override
    public List<ChargeOrder> loadChargeOrder(long userId, int limitNumber) {
        List<ChargeOrderJpaEntity> entities = repository.findAllByUserIdOrderByDate(userId, PageRequest.of(0, limitNumber));
        return mapper.mapToDomainEntity(entities);
    }

    @Override
    public List<ChargeOrder> loadChargeOrder(long userId, Date startDate, Date endDate) {
        List<ChargeOrderJpaEntity> entities = repository.findAllByUserIdAndDateAfterAndDateBeforeOrderByDate(userId, startDate, endDate, PageRequest.of(0, 5));
        return mapper.mapToDomainEntity(entities);
    }
}
