package info.toast1ng.toygameplatform.charge.application.port.out;

import info.toast1ng.toygameplatform.charge.domain.ChargeOrder;

public interface RegisterChargeOrderPort {
    long registerChargeOrder(ChargeOrder domainEntity);
}
