package info.toast1ng.toygameplatform.common.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@ToString
@AllArgsConstructor
@Getter
public class Gold {
    private int amount;

    public void multiplyGold(int amount) {
        this.amount *= amount;
    }

    public void addGold(int amount) {
        this.amount += amount;
    }

    public void subtractGold(int amount) {
        this.amount -= amount;
    }
}
