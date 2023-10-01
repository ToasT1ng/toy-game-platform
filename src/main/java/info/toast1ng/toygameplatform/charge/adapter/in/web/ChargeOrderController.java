package info.toast1ng.toygameplatform.charge.adapter.in.web;

import info.toast1ng.toygameplatform.charge.application.port.in.ChargeDiamondCommand;
import info.toast1ng.toygameplatform.charge.application.port.in.ChargeDiamondUseCase;
import info.toast1ng.toygameplatform.charge.domain.ExchangeRate;
import info.toast1ng.toygameplatform.charge.domain.FixedExchangeRates;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class ChargeOrderController {
    private final ChargeDiamondUseCase useCase;

    @PostMapping("/charge/diamond/{exchangeRateId}")
    public String chargeDiamond(ChargeDiamondVO vo, @PathVariable long exchangeRateId) {
        ExchangeRate exchangeRate = new FixedExchangeRates().getList().get((int) exchangeRateId);

        useCase.chargeDiamond(ChargeDiamondCommand.builder()
                .userId(vo.getUserId())
                .diamond(exchangeRate.getDiamond())
                .price(exchangeRate.getPrice())
                .build());
        return "success";
    }
}
