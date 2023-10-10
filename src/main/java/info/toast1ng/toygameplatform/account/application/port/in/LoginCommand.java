package info.toast1ng.toygameplatform.account.application.port.in;

import lombok.Data;

@Data
public class LoginCommand {
    private String username;
    private String password;
}
