package com.lina.airline.auth;

import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UserNamePwdAuthenticationProvider implements AuthenticationProvider {
    private final UserDetailsService userDetailsService;
     private final PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
      String userName= authentication.getName();
      String pwd=authentication.getCredentials().toString();
        UserDetails userDetails=userDetailsService.loadUserByUsername(userName);
        return new UsernamePasswordAuthenticationToken(userName,pwd);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
    }


}
