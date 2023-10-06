package info.toast1ng.toygameplatform.account.domain;

import info.toast1ng.toygameplatform.common.GoldType;
import info.toast1ng.toygameplatform.common.domain.Gold;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.Date;

@Builder
@ToString
@Getter
public class Account {
    public enum AccountGrade {user, admin}

    private long id;
    private String username;
    private String password;
    private AccountGrade grade;
    private Golds golds;
    private Date lastLogin;

    public void addDiamond(Gold diamond) {
        this.golds.diamond.addGold(diamond.getAmount());
    }

    public boolean isAbleToPay(GoldType goldType, Gold totalGold) {
        if (goldType.equals(GoldType.ruby)) {
            return this.golds.ruby.getAmount() >= totalGold.getAmount();
        } else {
            return this.golds.diamond.getAmount() >= totalGold.getAmount();
        }
    }

    public void payGold(GoldType goldType, Gold totalPrice) {
        if (goldType.equals(GoldType.ruby)) {
            this.golds.ruby.subtractGold(totalPrice.getAmount());
        } else {
            this.golds.diamond.subtractGold(totalPrice.getAmount());
        }
    }

    public void addRuby(Gold ruby) {
        this.golds.ruby.addGold(ruby.getAmount());
    }

    @ToString
    @Getter
    public static class Golds {
        private Gold ruby;
        private Gold diamond;

        @Builder
        public Golds(Gold ruby, Gold diamond) {
            this.ruby = ruby;
            this.diamond = diamond;
        }
    }
}
