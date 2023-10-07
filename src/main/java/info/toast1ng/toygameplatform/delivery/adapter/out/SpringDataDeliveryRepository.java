package info.toast1ng.toygameplatform.delivery.adapter.out;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpringDataDeliveryRepository extends JpaRepository<DeliveryJpaEntity, Long> {
    List<DeliveryJpaEntity> findAllByReceiverIdOrderByDateDesc(long userId, PageRequest pageRequest);
    List<DeliveryJpaEntity> findAllBySenderIdOrderByDateDesc(long userId, PageRequest pageRequest);
}
