package info.toast1ng.toygameplatform.charge.adapter.out.web;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class KakaoPayApproveApiRequest {
    private long orderId;
    private String pgToken;
}
