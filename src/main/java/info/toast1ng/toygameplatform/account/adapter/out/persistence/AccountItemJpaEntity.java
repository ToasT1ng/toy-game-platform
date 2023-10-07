package info.toast1ng.toygameplatform.account.adapter.out.persistence;

import info.toast1ng.toygameplatform.product.adapter.out.persistence.StoreProductJpaEntity;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Data
@Entity
@Table(name = "account_item")
public class AccountItemJpaEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "user_id")
    private long userId;

    @ManyToOne
    @JoinColumn(name = "store_product_id")
    private StoreProductJpaEntity product;

    private int amount;

    public AccountItemJpaEntity(long userId, long productId) {
        this.userId = userId;
        this.product = StoreProductJpaEntity.builder()
                .id(productId)
                .build();
        this.amount = 0;
    }

    @Builder
    public AccountItemJpaEntity(long id, long userId, StoreProductJpaEntity product, int amount) {
        this.id = id;
        this.userId = userId;
        this.product = product;
        this.amount = amount;
    }
}
