package info.toast1ng.toygameplatform.account.application.service;

import info.toast1ng.toygameplatform.account.application.port.in.LoginCommand;
import info.toast1ng.toygameplatform.account.application.port.in.LoginUseCase;
import info.toast1ng.toygameplatform.account.application.port.in.SignUpCommand;
import info.toast1ng.toygameplatform.account.application.port.out.RegisterAccountPort;
import info.toast1ng.toygameplatform.account.domain.Account;
import info.toast1ng.toygameplatform.common.domain.Gold;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;

@RequiredArgsConstructor
@Transactional
@Service
public class LoginService implements LoginUseCase {
    private final RegisterAccountPort registerAccountPort;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void signup(SignUpCommand command) {
        registerAccountPort.createAccount(Account.builder()
                .username(command.getUsername())
                .password(passwordEncoder.encode(command.getPassword()))
                .golds(Account.Golds.builder()
                        .ruby(new Gold(100))
                        .diamond(new Gold(0))
                        .build())
                .grade(Account.AccountGrade.user)
                .lastLogin(new Date())
                .build());
    }

    @Override
    public Account login(LoginCommand command) throws Exception {
//        Account account = loadAccountPort.loadAccount(command.getUsername());
//        if (!passwordEncoder.matches(command.getPassword(), account.getPassword())) {
//            throw new Exception("password not match");
//        }
//        return account;
        return null;
    }
}
