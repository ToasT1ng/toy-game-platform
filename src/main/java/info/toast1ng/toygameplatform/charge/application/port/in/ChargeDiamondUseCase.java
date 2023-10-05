package info.toast1ng.toygameplatform.charge.application.port.in;

import com.fasterxml.jackson.core.JsonProcessingException;
import info.toast1ng.toygameplatform.charge.adapter.out.web.ReadyApiResult;

public interface ChargeDiamondUseCase {
    ReadyApiResult ready(ReadyCommand readyCommand) throws JsonProcessingException;
    void approve(ApproveCommand readyCommand) throws Exception;
}
