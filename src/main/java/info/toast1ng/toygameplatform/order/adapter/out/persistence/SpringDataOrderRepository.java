package info.toast1ng.toygameplatform.order.adapter.out.persistence;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SpringDataOrderRepository extends JpaRepository<OrderJpaEntity, Long> {
    List<OrderJpaEntity> findAllByUserIdOrderByDateDesc(long userId, Pageable pageRequest);

    @Query(value = "select o from OrderJpaEntity o where o.user.username = :username order by o.date desc")
    List<OrderJpaEntity> findAllByUsernameOrderByDateDesc(String username, PageRequest pageRequest);
}
