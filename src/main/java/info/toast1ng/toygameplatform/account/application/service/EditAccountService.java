package info.toast1ng.toygameplatform.account.application.service;

import info.toast1ng.toygameplatform.account.application.port.in.ChangeAccountInfoCommand;
import info.toast1ng.toygameplatform.account.application.port.in.ChangeAccountPasswordCommand;
import info.toast1ng.toygameplatform.account.application.port.in.EditAccountUseCase;
import info.toast1ng.toygameplatform.account.application.port.out.LoadAccountPort;
import info.toast1ng.toygameplatform.account.application.port.out.UpdateAccountPort;
import info.toast1ng.toygameplatform.account.domain.Account;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Transactional
@Service
public class EditAccountService implements EditAccountUseCase {
    private final LoadAccountPort loadAccountPort;
    private final PasswordEncoder passwordEncoder;
    private final UpdateAccountPort updateAccountPort;

    @Override
    public void changeAccountInfo(ChangeAccountInfoCommand command) {
        Account account = loadAccountPort.loadAccount(command.getUserId());
        account.updateInfo(command);
        updateAccountPort.updateAccount(account);
    }

    @Override
    public void changeAccountPassword(ChangeAccountPasswordCommand command) throws Exception {
        Account account = loadAccountPort.loadAccount(command.getUserId());
        if (!passwordEncoder.matches(command.getCurrentPassword(), account.getPassword())) {
            throw new Exception("password not match");
        }

        account.updatePassword(passwordEncoder.encode(command.getNewPassword()));
        updateAccountPort.updateAccount(account);
    }
}
