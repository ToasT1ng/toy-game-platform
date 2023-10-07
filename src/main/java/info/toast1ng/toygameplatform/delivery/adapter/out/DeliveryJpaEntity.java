package info.toast1ng.toygameplatform.delivery.adapter.out;

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

    @Column(name = "sender_user_id")
    private long senderId;

    @Column(name = "receiver_user_id")
    private long receiverId;

    private Date date;

    private int ruby;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "state")
    private DeliveryState state;

    @Builder
    public DeliveryJpaEntity(long id, List<DeliveryItemJpaEntity> items, long senderId, long receiverId, Date date, int ruby, DeliveryState state) {
        this.id = id;
        this.items = items;
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.date = date;
        this.ruby = ruby;
        this.state = state;
    }
}
