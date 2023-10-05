package info.toast1ng.toygameplatform.charge.application.port.out;

import com.fasterxml.jackson.core.JsonProcessingException;
import info.toast1ng.toygameplatform.charge.adapter.out.web.ReadyApiResult;

public interface PayPort <RequestObject>{
    ReadyApiResult ready(RequestObject requestObject) throws JsonProcessingException;
}
