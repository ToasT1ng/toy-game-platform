package info.toast1ng.toygameplatform.charge.adapter.out.persistence;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface SpringDataChargeOrderRepository extends JpaRepository<ChargeOrderJpaEntity, Long> {
    List<ChargeOrderJpaEntity> findAllByUserIdOrderByDateDesc(long userId, Pageable pageable);
    List<ChargeOrderJpaEntity> findAllByUserIdAndDateAfterAndDateBeforeOrderByDateDesc(long userId, Date startDate, Date endDate, Pageable pageable);
}
