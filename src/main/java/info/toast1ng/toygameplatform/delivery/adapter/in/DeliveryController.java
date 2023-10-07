package info.toast1ng.toygameplatform.delivery.adapter.in;

import info.toast1ng.toygameplatform.delivery.application.port.in.ReceiveDeliveryUseCase;
import info.toast1ng.toygameplatform.delivery.application.port.in.SendDeliveryCommand;
import info.toast1ng.toygameplatform.delivery.application.port.in.SendDeliveryUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class DeliveryController {
    private final SendDeliveryUseCase sendDeliveryUseCase;
    private final ReceiveDeliveryUseCase receiveDeliveryUseCase;

    @PostMapping("/delivery")
    public String sendDelivery(@RequestBody SendDeliveryCommand command) throws Exception {
        sendDeliveryUseCase.sendDelivery(command);
        return "success";
    }
}
