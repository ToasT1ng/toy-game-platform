package info.toast1ng.toygameplatform.charge.adapter.in.web;

import com.fasterxml.jackson.core.JsonProcessingException;
import info.toast1ng.toygameplatform.charge.adapter.out.web.ReadyApiResult;
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
    private final TempApiResultComponent apiResultComponent;

    @PostMapping("/charge/diamond/{exchangeRateId}")
    public String chargeDiamond(ChargeDiamondVO vo, @PathVariable long exchangeRateId) throws JsonProcessingException {
        ExchangeRate exchangeRate = new FixedExchangeRates().getList().get((int) exchangeRateId);

        ReadyApiResult readyApiResult = useCase.chargeDiamond(ChargeDiamondCommand.builder()
                .userId(vo.getUserId())
                .diamond(exchangeRate.getDiamond())
                .price(exchangeRate.getPrice())
                .build());

        apiResultComponent.setReadyApiResult(readyApiResult);
        return "success";
    }
}
