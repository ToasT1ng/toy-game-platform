package info.toast1ng.toygameplatform.charge.adapter.in.web;

import info.toast1ng.toygameplatform.charge.application.port.in.PaymentType;
import info.toast1ng.toygameplatform.common.validation.ValidEnum;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
public class ChargeDiamondVO {
    @NotNull
    @Min(0)
    private long userId;

    @ValidEnum(enumClass = PaymentType.class)
    private String type;
}
