package info.toast1ng.toygameplatform.account.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface SpringDataAccountItemRepository extends JpaRepository<AccountItemJpaEntity, Long> {
    Optional<AccountItemJpaEntity> findByUserIdAndProductId(long userId, long productId);

    List<AccountItemJpaEntity> findAllByUserId(long userId);

    @Query(value = "select at from AccountItemJpaEntity at where at.userId = :userId and at.id IN :itemIds")
    List<AccountItemJpaEntity> findAllByUserIdAndItemIds(long userId, Set<Long> itemIds);
}
