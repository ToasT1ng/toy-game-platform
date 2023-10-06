package info.toast1ng.toygameplatform.charge.adapter.out.web;

import com.fasterxml.jackson.core.JsonProcessingException;
import info.toast1ng.toygameplatform.charge.application.port.out.PaycoPort;
import org.springframework.stereotype.Component;

@Component
public class PaycoAdapter implements PaycoPort {
    @Override
    public ReadyApiResult ready(ReadyApiRequest request) throws JsonProcessingException {
        //TODO 구현
        return null;
    }


    @Override
    public void approve(KakaoPayApproveApiRequest request) throws JsonProcessingException {
        //TODO 구현
    }
}
