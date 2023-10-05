package info.toast1ng.toygameplatform.charge.adapter.in.web;

import info.toast1ng.toygameplatform.charge.adapter.out.web.KakaoPayReadyApiResult;
import info.toast1ng.toygameplatform.charge.application.port.in.PaymentType;
import info.toast1ng.toygameplatform.charge.domain.ExchangeRate;
import lombok.Data;
import org.springframework.stereotype.Component;

//TODO DB를 이용한 결제정보 저장
@Data
@Component
public class TempApiResultComponent {
    private KakaoPayReadyApiResult readyApiResult;
    private ExchangeRate exchangeRate;
    private PaymentType paymentType;
}
