package info.toast1ng.toygameplatform.charge.adapter.out.persistence;

import info.toast1ng.toygameplatform.account.adapter.out.persistence.AccountJpaEntity;
import info.toast1ng.toygameplatform.charge.application.port.in.PaymentType;
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

    @ManyToOne
    @JoinColumn(name = "user_id")
    private AccountJpaEntity user;

    private Date date;
    private int price;
    private int diamond;

    @Column(name = "is_approved")
    private boolean isApproved;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "payment_type")
    private PaymentType paymentType;

    @Builder
    public ChargeOrderJpaEntity(long id, AccountJpaEntity user, Date date, int price, int diamond, boolean isApproved, PaymentType paymentType) {
        this.id = id;
        this.user = user;
        this.date = date;
        this.price = price;
        this.diamond = diamond;
        this.isApproved = isApproved;
        this.paymentType = paymentType;
    }
}
