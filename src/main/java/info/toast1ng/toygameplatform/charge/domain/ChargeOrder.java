package info.toast1ng.toygameplatform.charge.domain;

import info.toast1ng.toygameplatform.account.domain.Account;
import info.toast1ng.toygameplatform.common.domain.Gold;
import info.toast1ng.toygameplatform.common.domain.Money;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.Date;

@ToString
@Getter
@Builder
@AllArgsConstructor
public class ChargeOrder {
    private long id;
    private Account user;
    private Date date;
    private Money price;
    private Gold diamond;
}
