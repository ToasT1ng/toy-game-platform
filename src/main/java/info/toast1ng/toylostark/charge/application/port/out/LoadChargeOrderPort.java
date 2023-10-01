package info.toast1ng.toylostark.charge.application.port.out;

import info.toast1ng.toylostark.charge.domain.ChargeOrder;

import java.util.Date;
import java.util.List;

public interface LoadChargeOrderPort {
    List<ChargeOrder> loadChargeOrder(long userId, int limitNumber);
    List<ChargeOrder> loadChargeOrder(long userId, Date startDate, Date endDate);
}
