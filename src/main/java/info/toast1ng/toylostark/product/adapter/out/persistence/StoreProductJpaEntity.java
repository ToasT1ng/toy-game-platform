package info.toast1ng.toylostark.product.adapter.out.persistence;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@NoArgsConstructor
@Entity
@Data
@Table(name="store_product")
public class StoreProductJpaEntity {
    @Id
    private long id;
    private String name;
    private String category;
    private int price;

    @Builder
    public StoreProductJpaEntity(long id, String name, String category, int price) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
    }
}
