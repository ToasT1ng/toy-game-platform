package info.toast1ng.toylostark.charge.adapter.out.persistence;

import info.toast1ng.toylostark.account.adapter.out.persistence.AccountJpaEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
//@Entity
@Data
//@Table(name="charge_order")
public class OrderJpaEntity {
    private long id;

//    @Column(name = "user_id")
    private AccountJpaEntity user;

    private Date date;
    private int price;
    private int diamond;
}
