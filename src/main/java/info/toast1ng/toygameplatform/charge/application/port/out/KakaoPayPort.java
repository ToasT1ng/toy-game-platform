package info.toast1ng.toygameplatform.charge.application.port.out;

import com.fasterxml.jackson.core.JsonProcessingException;
import info.toast1ng.toygameplatform.charge.adapter.out.web.KakaoPayReadyApiRequest;
import info.toast1ng.toygameplatform.charge.adapter.out.web.ReadyApiResult;

public interface KakaoPayPort extends PayPort<KakaoPayReadyApiRequest>{
    ReadyApiResult ready(KakaoPayReadyApiRequest request) throws JsonProcessingException;
    void approve(String tid, String orderId, String pgToken) throws JsonProcessingException;
}
