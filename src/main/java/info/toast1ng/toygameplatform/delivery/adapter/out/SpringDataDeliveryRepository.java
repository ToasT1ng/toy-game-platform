package info.toast1ng.toygameplatform.delivery.adapter.out;

import info.toast1ng.toygameplatform.delivery.domain.DeliveryState;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface SpringDataDeliveryRepository extends JpaRepository<DeliveryJpaEntity, Long> {
    Optional<DeliveryJpaEntity> findByIdAndState(long id, DeliveryState state);

    List<DeliveryJpaEntity> findAllByReceiverIdOrderByDateDesc(long userId, PageRequest pageRequest);

    @Query(value = "select d from DeliveryJpaEntity d where d.receiver.username = :username order by d.date desc ")
    List<DeliveryJpaEntity> findAllByReceiverUsernameOrderByDateDesc(String username, PageRequest pageRequest);

    List<DeliveryJpaEntity> findAllBySenderIdOrderByDateDesc(long userId, PageRequest pageRequest);

    @Query(value = "select d from DeliveryJpaEntity d where d.sender.username = :username order by d.date desc ")
    List<DeliveryJpaEntity> findAllBySenderUsernameOrderByDateDesc(String username, PageRequest pageRequest);
}
