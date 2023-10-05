package info.toast1ng.toygameplatform.charge.adapter.in.web;

import info.toast1ng.toygameplatform.charge.application.port.in.ApproveCommand;
import info.toast1ng.toygameplatform.charge.application.port.in.ChargeDiamondUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequiredArgsConstructor
@Controller
public class WebContoller {
    private final ChargeDiamondUseCase useCase;
    private final TempApiResultComponent apiResultComponent;

    @GetMapping("/kakao/pay/completed")
    public String myPage(@RequestParam("pg_token") String pgToken) throws Exception {
        useCase.approve(ApproveCommand.builder()
                .pgToken(pgToken)
                .orderId(apiResultComponent.getReadyApiResult().getOrderId())
                .diamond(apiResultComponent.getExchangeRate().getDiamond())
                .tid(apiResultComponent.getReadyApiResult().getTid())
                .price(apiResultComponent.getExchangeRate().getPrice())
                .userId(apiResultComponent.getReadyApiResult().getUserId())
                .paymentType(apiResultComponent.getPaymentType())
                .build());

        return "redirect:/myPage";
    }
}
