package info.toast1ng.toygameplatform.product.adapter.out.persistence;

import info.toast1ng.toygameplatform.common.GoldType;
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
    private GoldType type;

    private int price;

    @Column(name = "delete_flag")
    private boolean deleteFlag;

    @Column(name = "image_url")
    private String imageUrl;

    @Builder
    public StoreProductJpaEntity(long id, String name, String category, GoldType type, int price, boolean deleteFlag, String imageUrl) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.type = type;
        this.price = price;
        this.deleteFlag = deleteFlag;
        this.imageUrl = imageUrl;
    }
}
