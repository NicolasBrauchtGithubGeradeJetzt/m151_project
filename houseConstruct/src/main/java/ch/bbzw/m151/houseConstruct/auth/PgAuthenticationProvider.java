package ch.bbzw.m151.houseConstruct.auth;

import ch.bbzw.m151.houseConstruct.model.UserGroup;
import ch.bbzw.m151.houseConstruct.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class PgAuthenticationProvider implements AuthenticationProvider {

    private final LoginService loginService;

    @Autowired
    public PgAuthenticationProvider(final LoginService loginService) {
        this.loginService = loginService;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String email = authentication.getName();
        String password = authentication.getCredentials().toString();

        /*if (loginService.login(email, password).isPresent()) {
            final UserGroup userGroup = loginService.login(email, password).get();
            return new UsernamePasswordAuthenticationToken(
                    email, 
                    password,
                    Collections.singletonList(new SimpleGrantedAuthority(userGroup.toString())));
        }*/

        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}