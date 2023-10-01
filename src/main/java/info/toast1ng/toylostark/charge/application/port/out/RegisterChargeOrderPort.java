package info.toast1ng.toylostark.charge.application.port.out;

import info.toast1ng.toylostark.charge.domain.ChargeOrder;

public interface RegisterChargeOrderPort {
    void registerChargeOrder(ChargeOrder domainEntity);
}
