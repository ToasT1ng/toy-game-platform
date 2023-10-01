package info.toast1ng.toygameplatform.charge.application.port.out;

import info.toast1ng.toygameplatform.charge.domain.ChargeOrder;

public interface RegisterChargeOrderPort {
    void registerChargeOrder(ChargeOrder domainEntity);
}
