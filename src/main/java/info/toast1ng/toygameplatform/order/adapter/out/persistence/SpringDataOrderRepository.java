package info.toast1ng.toygameplatform.order.adapter.out.persistence;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpringDataOrderRepository extends JpaRepository<OrderJpaEntity, Long> {
    List<OrderJpaEntity> findAllByUserIdOrderByDateDesc(long userId, Pageable pageable);
}
