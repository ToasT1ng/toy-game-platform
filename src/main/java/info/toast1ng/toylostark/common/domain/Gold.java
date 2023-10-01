package info.toast1ng.toylostark.common.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@ToString
@AllArgsConstructor
@Getter
public class Gold {
    private int amount;

    public void addGold(int amount) {
        this.amount += amount;
    }
}
