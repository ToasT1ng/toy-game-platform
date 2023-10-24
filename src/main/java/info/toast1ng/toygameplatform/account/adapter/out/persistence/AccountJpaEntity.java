package info.toast1ng.toygameplatform.account.adapter.out.persistence;

import info.toast1ng.toygameplatform.account.domain.Account;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor
@Entity
@Data
@Table(name="account")
public class AccountJpaEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String username;
    private String password;

    @Column(name = "mail_address")
    private String mailAddress;

    @Column(name = "nickname")
    private String nickname;

    @Enumerated(value = EnumType.STRING)
    private Account.AccountGrade grade;
    private int ruby;
    private int diamond;

    @Column(name="last_login")
    private Date lastLogin;

    @Builder
    public AccountJpaEntity(long id, String username, String password, String mailAddress, String nickname, Account.AccountGrade grade, int ruby, int diamond, Date lastLogin) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.mailAddress = mailAddress;
        this.nickname = nickname;
        this.grade = grade;
        this.ruby = ruby;
        this.diamond = diamond;
        this.lastLogin = lastLogin;
    }
}
