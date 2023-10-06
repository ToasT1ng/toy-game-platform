package info.toast1ng.toygameplatform.charge.adapter.out.web;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class KakaoPayApproveApiRequest {
    private String tid;
    private String orderId;
    private String pgToken;
}
