package info.toast1ng.toygameplatform.charge.adapter.out.persistence;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface SpringDataChargeOrderRepository extends JpaRepository<ChargeOrderJpaEntity, Long> {
    List<ChargeOrderJpaEntity> findAllByUserIdOrderByDate(long userId, Pageable pageable);
    List<ChargeOrderJpaEntity> findAllByUserIdAndDateAfterAndDateBeforeOrderByDate(long userId, Date startDate, Date endDate, Pageable pageable);
}
