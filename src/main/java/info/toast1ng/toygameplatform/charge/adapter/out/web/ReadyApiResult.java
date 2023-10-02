package info.toast1ng.toygameplatform.charge.adapter.out.web;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.HashMap;

@ToString
@AllArgsConstructor
@Getter
public class ReadyApiResult {
    private long orderId;
    private String tid;
    private String redirectUrl;


    public ReadyApiResult(long orderId, HashMap jsonObject) {
        this.orderId = orderId;
        this.tid = jsonObject.get("tid").toString();
        this.redirectUrl = jsonObject.get("next_redirect_pc_url").toString();
    }
}
