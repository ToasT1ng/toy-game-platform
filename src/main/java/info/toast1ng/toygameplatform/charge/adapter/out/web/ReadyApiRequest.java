package info.toast1ng.toygameplatform.charge.adapter.out.web;

import info.toast1ng.toygameplatform.common.domain.Gold;
import info.toast1ng.toygameplatform.common.domain.Money;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ReadyApiRequest {
    private long userId;
    private Money price;
    private Gold diamond;
}
