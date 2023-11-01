package info.toast1ng.toygameplatform.account.application.port.in;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class SignUpCommand {
    @NotNull
    @NotBlank
    private String username;

    @NotNull
    @NotBlank
    private String password;

    @NotNull
    @NotBlank
    @Email
    private String mailAddress;

    @NotNull
    @NotBlank
    private String nickname;
}
