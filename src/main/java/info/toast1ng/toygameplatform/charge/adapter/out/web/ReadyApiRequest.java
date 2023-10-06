package info.toast1ng.toygameplatform.charge.adapter.out.web;

import info.toast1ng.toygameplatform.charge.application.port.in.ReadyCommand;
import info.toast1ng.toygameplatform.common.domain.Gold;
import info.toast1ng.toygameplatform.common.domain.Money;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ReadyApiRequest {
    private long orderId;
    private long userId;
    private Money price;
    private Gold diamond;

    public ReadyApiRequest(long orderId, ReadyCommand readyCommand) {
        this.orderId = orderId;
        this.userId = readyCommand.getUserId();
        this.price = readyCommand.getPrice();
        this.diamond = readyCommand.getDiamond();
    }
}
