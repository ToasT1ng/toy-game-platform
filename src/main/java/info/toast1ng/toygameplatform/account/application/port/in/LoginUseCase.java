package info.toast1ng.toygameplatform.account.application.port.in;

public interface LoginUseCase {
    void signup(SignUpCommand command);
    void login(LoginCommand command);
}
