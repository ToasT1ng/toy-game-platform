package info.toast1ng.toygameplatform.charge.adapter.out.web;

import lombok.Getter;
import lombok.ToString;

import java.util.HashMap;

@ToString
@Getter
public class PaycoReadyApiResult extends ReadyApiResult{
    private String orderId;

    public PaycoReadyApiResult(String orderId, long userId, HashMap jsonObject) {
        this.orderId = orderId;
        this.userId = userId;
        this.redirectUrl = jsonObject.get("orderSheetUrl").toString();
    }
}
