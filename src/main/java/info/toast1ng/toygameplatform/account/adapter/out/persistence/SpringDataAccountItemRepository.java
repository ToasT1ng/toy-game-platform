package info.toast1ng.toygameplatform.account.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SpringDataAccountItemRepository extends JpaRepository<AccountItemJpaEntity, Long> {
    Optional<AccountItemJpaEntity> findByUserIdAndProductId(long userId, long productId);

    List<AccountItemJpaEntity> findAllByUserId(long userId);
}
