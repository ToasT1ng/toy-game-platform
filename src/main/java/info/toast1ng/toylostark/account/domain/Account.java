package info.toast1ng.toylostark.account.domain;

import info.toast1ng.toylostark.common.domain.Gold;
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
