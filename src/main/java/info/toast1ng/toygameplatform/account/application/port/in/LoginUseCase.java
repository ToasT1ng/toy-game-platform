package info.toast1ng.toygameplatform.account.application.port.in;

import info.toast1ng.toygameplatform.account.domain.Account;

public interface LoginUseCase {
    void signup(SignUpCommand command);
    Account login(LoginCommand command) throws Exception;
}
