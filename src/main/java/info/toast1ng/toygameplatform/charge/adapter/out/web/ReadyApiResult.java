package info.toast1ng.toygameplatform.charge.adapter.out.web;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ReadyApiResult {
    protected long orderId;
    protected long userId;
    protected String redirectUrl;
}
