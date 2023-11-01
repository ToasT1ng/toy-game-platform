package info.toast1ng.toygameplatform.order.adapter.in.web;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class RegisterOrderVO {
    @NotNull
    @Min(0)
    private long userId;

    @NotNull
    @Min(0)
    private long productId;

    @NotNull
    @Min(1)
    private int amount;
}
