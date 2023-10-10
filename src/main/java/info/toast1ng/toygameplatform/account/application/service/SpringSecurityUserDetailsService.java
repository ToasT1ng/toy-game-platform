package info.toast1ng.toygameplatform.account.application.service;

import info.toast1ng.toygameplatform.account.application.port.out.LoadAccountPort;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Transactional
@Service
public class SpringSecurityUserDetailsService implements UserDetailsService {
    private final LoadAccountPort loadAccountPort;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return loadAccountPort.loadAccount(username);
    }
}
