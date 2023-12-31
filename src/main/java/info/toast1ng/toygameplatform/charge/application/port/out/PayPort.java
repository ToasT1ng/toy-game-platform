package info.toast1ng.toygameplatform.charge.application.port.out;

import com.fasterxml.jackson.core.JsonProcessingException;
import info.toast1ng.toygameplatform.charge.adapter.out.web.ReadyApiRequest;
import info.toast1ng.toygameplatform.charge.adapter.out.web.ReadyApiResult;

public interface PayPort <ApproveRequestObject>{
    ReadyApiResult ready(ReadyApiRequest request) throws JsonProcessingException;
    void approve(ApproveRequestObject request) throws JsonProcessingException;
}
