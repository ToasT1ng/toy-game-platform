package info.toast1ng.toygameplatform.account.application.port.in;

public interface EditAccountUseCase {
    void changeAccountInfo(ChangeAccountInfoCommand command);
    void changeAccountPassword(ChangeAccountPasswordCommand command) throws Exception;
}
