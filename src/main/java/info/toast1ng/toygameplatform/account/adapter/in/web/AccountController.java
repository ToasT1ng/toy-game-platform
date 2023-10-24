package info.toast1ng.toygameplatform.account.adapter.in.web;

import info.toast1ng.toygameplatform.account.application.port.in.*;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@Configuration
@RestController
public class AccountController {
    private final LoginUseCase loginUseCase;
    private final EditAccountUseCase editAccountUseCase;

    @PostMapping(value = "/account")
    public String registerAccount(SignUpCommand command) {
        loginUseCase.signup(command);
        return "success";
    }

    @PutMapping(value = "/account")
    public String changeAccountInfo(@RequestBody ChangeAccountInfoCommand command) {
        editAccountUseCase.changeAccountInfo(command);
        return "success";
    }

    @PutMapping(value = "/account/password")
    public String changeAccountPassword(@RequestBody ChangeAccountPasswordCommand command) throws Exception {
        editAccountUseCase.changeAccountPassword(command);
        return "success";
    }
}
