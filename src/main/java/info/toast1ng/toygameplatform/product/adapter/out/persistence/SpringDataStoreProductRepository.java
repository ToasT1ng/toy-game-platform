package info.toast1ng.toygameplatform.product.adapter.out.persistence;

import info.toast1ng.toygameplatform.common.GoldType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SpringDataStoreProductRepository extends JpaRepository<StoreProductJpaEntity, Long> {
    @Query("select s from StoreProductJpaEntity s where s.deleteFlag=false")
    List<StoreProductJpaEntity> findAll();

    @Query("select s from StoreProductJpaEntity s where s.deleteFlag=false and s.name like concat('%',:nameKeyword,'%')")
    Page<StoreProductJpaEntity> findAllByNameContains(String nameKeyword, Pageable pageRequest);

    @Query("select s from StoreProductJpaEntity s where s.deleteFlag=false and s.name like concat('%',:nameKeyword,'%') and s.type = :goldType")
    Page<StoreProductJpaEntity> findAllByNameContainsAndGoldType(String nameKeyword, GoldType goldType, Pageable pageRequest);

    @Query("select s from StoreProductJpaEntity s where s.deleteFlag=false and s.type = :goldType")
    Page<StoreProductJpaEntity> findAllByGoldType(GoldType goldType, Pageable pageRequest);

    @Query("select s from StoreProductJpaEntity s where s.deleteFlag=false and s.id = :id")
    StoreProductJpaEntity findById(long id);

    @Modifying
    @Query("update StoreProductJpaEntity s set s.deleteFlag=true where s.id = :id")
    void deleteStoreProduct(long id);
}
