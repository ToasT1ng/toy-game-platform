package info.toast1ng.toygameplatform.account.adapter.in.web;

import info.toast1ng.toygameplatform.account.application.port.in.LoginCommand;
import info.toast1ng.toygameplatform.account.application.port.in.LoginUseCase;
import info.toast1ng.toygameplatform.account.application.port.in.SignUpCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@Configuration
@RestController
public class AccountController {
    private final LoginUseCase loginUseCase;

    @PostMapping(value = "/account")
    public String registerAccount(SignUpCommand command) {
        loginUseCase.signup(command);
        return "success";
    }

    @PostMapping(value = "/login")
    public String login(LoginCommand command) {
        loginUseCase.login(command);
        return "success";
    }

}
