package info.toast1ng.toygameplatform.charge.application.port.in;

import info.toast1ng.toygameplatform.charge.domain.ChargeOrder;

import java.util.List;

public interface GetChargeOrderQuery {
    List<ChargeOrder> getChargeOrders(long userId);

    List<ChargeOrder> getChargeOrders(String username);
}
