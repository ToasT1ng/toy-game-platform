package info.toast1ng.toygameplatform.charge.adapter.in.web;

import com.fasterxml.jackson.core.JsonProcessingException;
import info.toast1ng.toygameplatform.charge.adapter.out.web.ReadyApiResult;
import info.toast1ng.toygameplatform.charge.application.port.in.ChargeDiamondUseCase;
import info.toast1ng.toygameplatform.charge.application.port.in.PaymentType;
import info.toast1ng.toygameplatform.charge.application.port.in.ReadyCommand;
import info.toast1ng.toygameplatform.charge.domain.ExchangeRate;
import info.toast1ng.toygameplatform.charge.domain.FixedExchangeRates;
import info.toast1ng.toygameplatform.common.WebAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@WebAdapter
@RequiredArgsConstructor
@RestController
public class ChargeOrderController {
    private final ChargeDiamondUseCase useCase;

    @PostMapping("/charge/diamond/{exchangeRateId}")
    public ReadyApiResult chargeDiamond(@Valid ChargeDiamondVO vo, @PathVariable long exchangeRateId) throws JsonProcessingException {
        ExchangeRate exchangeRate = new FixedExchangeRates().getList().get((int) exchangeRateId);

        return useCase.ready(ReadyCommand.builder()
                .userId(vo.getUserId())
                .diamond(exchangeRate.getDiamond())
                .price(exchangeRate.getPrice())
                .paymentType(PaymentType.valueOf(vo.getType()))
                .build());
    }
}
