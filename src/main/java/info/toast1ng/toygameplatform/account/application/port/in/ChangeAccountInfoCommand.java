package info.toast1ng.toygameplatform.account.application.port.in;

import lombok.Data;

@Data
public class ChangeAccountInfoCommand {
    private long userId;
    private String mailAddress;
    private String nickname;
}
