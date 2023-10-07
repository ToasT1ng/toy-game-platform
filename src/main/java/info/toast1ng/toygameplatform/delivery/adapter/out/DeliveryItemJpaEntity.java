package info.toast1ng.toygameplatform.delivery.adapter.out;

import info.toast1ng.toygameplatform.product.adapter.out.persistence.StoreProductJpaEntity;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Data
@Entity
@Table(name = "delivery_item")
public class DeliveryItemJpaEntity {
    @Id
    private long id;

    @ManyToOne
    @JoinColumn(name = "store_product_id")
    private StoreProductJpaEntity product;

    @ManyToOne
    @JoinColumn(name = "delivery_id")
    private DeliveryJpaEntity delivery;

    private int amount;

    @Builder
    public DeliveryItemJpaEntity(long id, StoreProductJpaEntity product, DeliveryJpaEntity delivery, int amount) {
        this.id = id;
        this.product = product;
        this.delivery = delivery;
        this.amount = amount;
    }
}
