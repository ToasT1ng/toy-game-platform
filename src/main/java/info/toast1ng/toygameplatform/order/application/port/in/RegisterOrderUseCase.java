package info.toast1ng.toygameplatform.order.application.port.in;

import info.toast1ng.toygameplatform.order.application.service.RegisterOrderCommand;

public interface RegisterOrderUseCase {
    void registerOrder(RegisterOrderCommand order) throws Exception;
}
