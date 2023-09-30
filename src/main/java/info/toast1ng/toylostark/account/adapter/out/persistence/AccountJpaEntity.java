package info.toast1ng.toylostark.account.adapter.out.persistence;

import info.toast1ng.toylostark.account.domain.Account;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
//@Entity
@Data
//@Table(name="account")
public class AccountJpaEntity {
//    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String username;
    private String password;
    private Account.AccountGrade grade;
    private int ruby;
    private int diamond;

//    @Column(name="last_login")
    private Date lastLogin;

    @Builder
    public AccountJpaEntity(long id, String username, String password, Account.AccountGrade grade, int ruby, int diamond, Date lastLogin) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.grade = grade;
        this.ruby = ruby;
        this.diamond = diamond;
        this.lastLogin = lastLogin;
    }
}
