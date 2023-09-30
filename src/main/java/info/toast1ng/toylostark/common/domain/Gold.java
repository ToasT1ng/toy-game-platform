package info.toast1ng.toylostark.common.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Gold {
    private int amount;

    public void addGold(int amount) {
        this.amount += amount;
    }
}
