package info.toast1ng.toygameplatform.account.application.port.in;

import lombok.Data;

@Data
public class ChangeAccountPasswordCommand {
    private long userId;
    private String currentPassword;
    private String newPassword;
}
