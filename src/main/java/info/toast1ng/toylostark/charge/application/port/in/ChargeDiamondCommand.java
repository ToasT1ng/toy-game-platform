package info.toast1ng.toylostark.charge.application.port.in;

import info.toast1ng.toylostark.common.domain.Gold;
import info.toast1ng.toylostark.common.domain.Money;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ChargeDiamondCommand {
    private long userId;
    private Money price;
    private Gold diamond;
}
