package info.toast1ng.toygameplatform.charge.adapter.out.web;

import lombok.Getter;
import lombok.ToString;

import java.util.HashMap;

@ToString
@Getter
public class KakaoPayReadyApiResult extends ReadyApiResult{
    public KakaoPayReadyApiResult(long orderId, long userId, HashMap jsonObject) {
        this.orderId = orderId;
        this.userId = userId;
        this.redirectUrl = jsonObject.get("next_redirect_pc_url").toString();
    }
}
