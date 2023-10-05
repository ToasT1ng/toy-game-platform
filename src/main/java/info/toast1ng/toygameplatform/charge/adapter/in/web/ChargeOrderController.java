package info.toast1ng.toygameplatform.charge.adapter.in.web;

import com.fasterxml.jackson.core.JsonProcessingException;
import info.toast1ng.toygameplatform.charge.adapter.out.web.KakaoPayReadyApiResult;
import info.toast1ng.toygameplatform.charge.adapter.out.web.ReadyApiResult;
import info.toast1ng.toygameplatform.charge.application.port.in.ReadyCommand;
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
    public ReadyApiResult chargeDiamond(ChargeDiamondVO vo, @PathVariable long exchangeRateId) throws JsonProcessingException {
        ExchangeRate exchangeRate = new FixedExchangeRates().getList().get((int) exchangeRateId);

        KakaoPayReadyApiResult readyApiResult = (KakaoPayReadyApiResult) useCase.ready(ReadyCommand.builder()
                .userId(vo.getUserId())
                .diamond(exchangeRate.getDiamond())
                .price(exchangeRate.getPrice())
                .paymentType(vo.getType())
                .build());

        apiResultComponent.setReadyApiResult(readyApiResult);
        apiResultComponent.setExchangeRate(exchangeRate);
        apiResultComponent.setPaymentType(vo.getType());
        return readyApiResult;
    }
}
