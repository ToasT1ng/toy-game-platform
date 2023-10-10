package info.toast1ng.toygameplatform.charge.application.service;

import info.toast1ng.toygameplatform.account.application.port.out.LoadAccountPort;
import info.toast1ng.toygameplatform.charge.application.port.in.GetChargeOrderQuery;
import info.toast1ng.toygameplatform.charge.application.port.out.LoadChargeOrderPort;
import info.toast1ng.toygameplatform.charge.domain.ChargeOrder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@RequiredArgsConstructor
@Service
public class GetChargeOrderService implements GetChargeOrderQuery {
    private final LoadChargeOrderPort port;
    private final LoadAccountPort loadAccountPort;

    @Override
    public List<ChargeOrder> getChargeOrders(long userId) {
        return port.loadChargeOrders(userId, 5);
    }

    @Override
    public List<ChargeOrder> getChargeOrders(String username) {
        return port.loadChargeOrders(loadAccountPort.loadAccount(username).getId(), 5);
    }
}
