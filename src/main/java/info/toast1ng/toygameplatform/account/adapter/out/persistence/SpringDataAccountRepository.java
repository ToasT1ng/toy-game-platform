package info.toast1ng.toygameplatform.account.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataAccountRepository extends JpaRepository<AccountJpaEntity, Long> {
    Optional<AccountJpaEntity> findByUsername(String username);
}
