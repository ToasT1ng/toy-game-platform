package info.toast1ng.toygameplatform.charge.application.port.out;

import info.toast1ng.toygameplatform.charge.domain.ChargeOrder;

import java.util.List;

public interface LoadChargeOrderPort {
    List<ChargeOrder> loadChargeOrders(long userId, int limitNumber);
    List<ChargeOrder> loadChargeOrders(String username, int limitNumber);
    ChargeOrder loadChargeOrder(long orderId);
}
