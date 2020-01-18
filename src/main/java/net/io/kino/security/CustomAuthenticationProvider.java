package net.io.kino.security;

import net.io.kino.service.AuthenticationManager;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

import java.util.ArrayList;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    private AuthenticationManager auth;

    @Override
    public Authentication authenticate(Authentication authentication) {

        try{
            String name = authentication.getName();
            String password = authentication.getCredentials().toString();

            if (auth.login(name, password)) {
                return new UsernamePasswordAuthenticationToken(
                        name, password, new ArrayList<>());
            } else {
                return null;
            }
        } catch (AuthenticationException ex){
            System.out.println(ex.getMessage());
        }

        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
