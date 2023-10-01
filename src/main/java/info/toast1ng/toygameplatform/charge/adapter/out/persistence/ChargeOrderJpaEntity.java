package info.toast1ng.toygameplatform.charge.adapter.out.persistence;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor
@Entity
@Data
@Table(name="charge_order")
public class ChargeOrderJpaEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    //TODO 연관관계 맺기 & DB에 FK 설정하기
    @Column(name = "user_id")
    private long userId;

    private Date date;
    private int price;
    private int diamond;

    @Builder
    public ChargeOrderJpaEntity(long id, long userId, Date date, int price, int diamond) {
        this.id = id;
        this.userId = userId;
        this.date = date;
        this.price = price;
        this.diamond = diamond;
    }
}
