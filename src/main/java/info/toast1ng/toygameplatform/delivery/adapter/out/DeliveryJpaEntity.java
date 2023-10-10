package info.toast1ng.toygameplatform.delivery.adapter.out;

import info.toast1ng.toygameplatform.account.adapter.out.persistence.AccountJpaEntity;
import info.toast1ng.toygameplatform.delivery.domain.DeliveryState;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@Data
@Table(name = "delivery_order")
@Entity
public class DeliveryJpaEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToMany(mappedBy = "delivery", cascade = CascadeType.PERSIST)
    private List<DeliveryItemJpaEntity> items;

    @ManyToOne
    @JoinColumn(name = "sender_user_id")
    private AccountJpaEntity sender;

    @ManyToOne
    @JoinColumn(name = "receiver_user_id")
    private AccountJpaEntity receiver;

    private Date date;

    private int ruby;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "state")
    private DeliveryState state;

    @Builder
    public DeliveryJpaEntity(long id, List<DeliveryItemJpaEntity> items, AccountJpaEntity sender, AccountJpaEntity receiver, Date date, int ruby, DeliveryState state) {
        this.id = id;
        this.items = items;
        this.sender = sender;
        this.receiver = receiver;
        this.date = date;
        this.ruby = ruby;
        this.state = state;
    }
}
