package info.toast1ng.toygameplatform.charge.adapter.out.web;

import lombok.Getter;
import lombok.ToString;

import java.util.HashMap;

@ToString
@Getter
public class KakaoPayReadyApiResult extends ReadyApiResult{
    private String orderId;
    private String tid;

    public KakaoPayReadyApiResult(String orderId, long userId, HashMap jsonObject) {
        this.orderId = orderId;
        this.userId = userId;
        this.tid = jsonObject.get("tid").toString();
        this.redirectUrl = jsonObject.get("next_redirect_pc_url").toString();
    }

    public KakaoPayReadyApiResult(ReadyApiResult readyApiResult, String tid, String orderId) {
        this.orderId = orderId;
        this.tid = tid;
        this.userId = readyApiResult.getUserId();
        this.redirectUrl = readyApiResult.getRedirectUrl();
    }

    public KakaoPayReadyApiResult(String orderId, String tid, long userId, String redirectUrl) {
        this.orderId = orderId;
        this.tid = tid;
        this.userId = userId;
        this.redirectUrl = redirectUrl;
    }
}
