package info.toast1ng.toygameplatform.charge.adapter.in.web;

import info.toast1ng.toygameplatform.charge.application.port.in.ApproveCommand;
import info.toast1ng.toygameplatform.charge.application.port.in.ChargeDiamondUseCase;
import info.toast1ng.toygameplatform.common.WebAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@WebAdapter
@RequiredArgsConstructor
@Controller
public class WebContoller {
    private final ChargeDiamondUseCase useCase;

    @GetMapping("/kakao/pay/{orderId}/completed")
    public String myPage(@RequestParam("pg_token") String pgToken, @PathVariable long orderId) throws Exception {
        useCase.approve(ApproveCommand.builder()
                .pgToken(pgToken)
                .orderId(orderId)
                .build());

        return "redirect:/my-charges";
    }
}
