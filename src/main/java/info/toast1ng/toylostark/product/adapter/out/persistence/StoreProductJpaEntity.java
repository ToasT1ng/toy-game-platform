package info.toast1ng.toylostark.product.adapter.out.persistence;

import info.toast1ng.toylostark.product.domain.StoreProduct;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Entity
@Data
@Table(name="store_product")
public class StoreProductJpaEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String category;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "gold_type")
    private StoreProduct.GoldType type;

    private int price;

    @Column(name = "delete_flag")
    private boolean deleteFlag;

    @Builder
    public StoreProductJpaEntity(long id, String name, String category, StoreProduct.GoldType type, int price, boolean deleteFlag) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.type = type;
        this.price = price;
        this.deleteFlag = deleteFlag;
    }
}
