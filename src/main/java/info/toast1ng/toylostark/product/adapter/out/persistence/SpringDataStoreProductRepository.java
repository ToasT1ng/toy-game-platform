package info.toast1ng.toylostark.product.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataStoreProductRepository extends JpaRepository<StoreProductJpaEntity, Long> {
}
