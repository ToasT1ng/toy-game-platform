package info.toast1ng.toylostark.product.adapter.out.persistence;

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
    private int price;

    @Column(name = "delete_flag")
    private boolean deleteFlag;

    @Builder
    public StoreProductJpaEntity(long id, String name, String category, int price, boolean deleteFlag) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.deleteFlag = deleteFlag;
    }
}
