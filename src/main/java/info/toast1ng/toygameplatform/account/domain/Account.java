package info.toast1ng.toygameplatform.account.domain;

import info.toast1ng.toygameplatform.common.GoldType;
import info.toast1ng.toygameplatform.common.domain.Gold;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

@Builder
@ToString
@Getter
public class Account implements UserDetails {
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

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(grade.name());
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(authority);

        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() { return true; }

    @Override
    public boolean isAccountNonLocked() { return true; }

    @Override
    public boolean isCredentialsNonExpired() { return true; }

    @Override
    public boolean isEnabled() { return true; }

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
