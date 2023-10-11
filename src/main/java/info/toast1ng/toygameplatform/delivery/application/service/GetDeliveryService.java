package info.toast1ng.toygameplatform.delivery.application.service;

import info.toast1ng.toygameplatform.delivery.application.port.in.GetDeliveryQuery;
import info.toast1ng.toygameplatform.delivery.application.port.out.LoadDeliveryPort;
import info.toast1ng.toygameplatform.delivery.domain.Delivery;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@RequiredArgsConstructor
@Service
public class GetDeliveryService implements GetDeliveryQuery {
    private final LoadDeliveryPort loadDeliveryPort;

    @Override
    public List<Delivery> getReceivedDeliveries(long userId) {
        return loadDeliveryPort.loadReceivedDelivery(userId);
    }

    @Override
    public List<Delivery> getReceivedDeliveries(String username) {
        return loadDeliveryPort.loadReceivedDelivery(username);
    }

    @Override
    public List<Delivery> getSendDeliveries(long userId) {
        return loadDeliveryPort.loadSendDelivery(userId);
    }

    @Override
    public List<Delivery> getSendDeliveries(String username) {
        return loadDeliveryPort.loadSendDelivery(username);
    }
}
