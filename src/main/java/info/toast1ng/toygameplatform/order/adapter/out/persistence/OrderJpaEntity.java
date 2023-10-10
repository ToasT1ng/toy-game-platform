package info.toast1ng.toygameplatform.order.adapter.out.persistence;

import info.toast1ng.toygameplatform.account.adapter.out.persistence.AccountJpaEntity;
import info.toast1ng.toygameplatform.common.GoldType;
import info.toast1ng.toygameplatform.product.adapter.out.persistence.StoreProductJpaEntity;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Table(name = "store_product_order")
public class OrderJpaEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private AccountJpaEntity user;

    private Date date;

    @ManyToOne
    @JoinColumn(name = "store_product_id")
    private StoreProductJpaEntity product;

    @Column(name = "amount")
    private int productAmount;

    @Column(name = "gold_type")
    private GoldType goldType;

    private int price;

    @Builder
    public OrderJpaEntity(long id, AccountJpaEntity user, Date date, StoreProductJpaEntity product, int productAmount, GoldType goldType, int price) {
        this.id = id;
        this.user = user;
        this.date = date;
        this.product = product;
        this.productAmount = productAmount;
        this.goldType = goldType;
        this.price = price;
    }
}
