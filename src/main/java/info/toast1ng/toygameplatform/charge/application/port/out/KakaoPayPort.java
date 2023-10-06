package info.toast1ng.toygameplatform.charge.application.port.out;

import com.fasterxml.jackson.core.JsonProcessingException;
import info.toast1ng.toygameplatform.charge.adapter.out.web.ReadyApiRequest;
import info.toast1ng.toygameplatform.charge.adapter.out.web.ReadyApiResult;
import info.toast1ng.toygameplatform.charge.adapter.out.web.KakaoPayApproveApiRequest;

public interface KakaoPayPort extends PayPort<KakaoPayApproveApiRequest>{
    ReadyApiResult ready(ReadyApiRequest request) throws JsonProcessingException;
    void approve(KakaoPayApproveApiRequest request) throws JsonProcessingException;
}
