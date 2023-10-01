package info.toast1ng.toylostark.charge.application.port.in;

import info.toast1ng.toylostark.charge.domain.ChargeOrder;

import java.util.List;

public interface GetChargeOrderQuery {
    List<ChargeOrder> getChargeOrders(long userId);
}
