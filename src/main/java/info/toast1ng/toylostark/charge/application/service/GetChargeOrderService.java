package info.toast1ng.toylostark.charge.application.service;

import info.toast1ng.toylostark.charge.application.port.in.GetChargeOrderQuery;
import info.toast1ng.toylostark.charge.application.port.out.LoadChargeOrderPort;
import info.toast1ng.toylostark.charge.domain.ChargeOrder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@RequiredArgsConstructor
@Service
public class GetChargeOrderService implements GetChargeOrderQuery {
    private final LoadChargeOrderPort port;

    @Override
    public List<ChargeOrder> getChargeOrders(long userId) {
        return port.loadChargeOrder(userId, 5);
    }
}
