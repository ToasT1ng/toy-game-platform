package info.toast1ng.toygameplatform.charge.adapter.in.web;

import info.toast1ng.toygameplatform.charge.application.port.in.PaymentType;
import lombok.Data;

@Data
public class ChargeDiamondVO {
    private long userId;
    private PaymentType type;
}
