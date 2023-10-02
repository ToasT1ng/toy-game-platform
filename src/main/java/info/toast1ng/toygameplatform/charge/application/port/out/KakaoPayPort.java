package info.toast1ng.toygameplatform.charge.application.port.out;

import com.fasterxml.jackson.core.JsonProcessingException;
import info.toast1ng.toygameplatform.charge.adapter.out.web.ReadyApiResult;
import info.toast1ng.toygameplatform.charge.application.port.in.ChargeDiamondCommand;

public interface KakaoPayPort {
    ReadyApiResult billing(long orderId, ChargeDiamondCommand chargeDiamondCommand) throws JsonProcessingException;
    ReadyApiResult ready(long orderId, ChargeDiamondCommand chargeDiamondCommand) throws JsonProcessingException;
    void approve(String tid, long orderId, String pgToken) throws JsonProcessingException;
}
