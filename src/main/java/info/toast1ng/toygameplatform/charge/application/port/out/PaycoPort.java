package info.toast1ng.toygameplatform.charge.application.port.out;

import com.fasterxml.jackson.core.JsonProcessingException;
import info.toast1ng.toygameplatform.charge.adapter.out.web.KakaoPayApproveApiRequest;
import info.toast1ng.toygameplatform.charge.adapter.out.web.ReadyApiRequest;
import info.toast1ng.toygameplatform.charge.adapter.out.web.ReadyApiResult;

public interface PaycoPort extends PayPort<KakaoPayApproveApiRequest>{
    ReadyApiResult ready(ReadyApiRequest request) throws JsonProcessingException;
    void approve(KakaoPayApproveApiRequest request) throws JsonProcessingException;
}
