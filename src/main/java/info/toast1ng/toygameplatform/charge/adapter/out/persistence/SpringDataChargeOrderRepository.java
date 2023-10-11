package info.toast1ng.toygameplatform.charge.adapter.out.persistence;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SpringDataChargeOrderRepository extends JpaRepository<ChargeOrderJpaEntity, Long> {
    @Query("select o from ChargeOrderJpaEntity o where o.user.id = :userId and o.isApproved = true order by o.date desc")
    List<ChargeOrderJpaEntity> findAllByUserIdOrderByDateDesc(long userId, Pageable pageRequest);


    @Query("select o from ChargeOrderJpaEntity o where o.user.username = :username and o.isApproved = true order by o.date desc")
    List<ChargeOrderJpaEntity> findAllByUsernameOrderByDateDesc(String username, PageRequest pageRequest);

    @Modifying
    @Query("update ChargeOrderJpaEntity o set o.isApproved = true")
    void updateApprovedStateToTrueByOrderId(long orderId);
}
