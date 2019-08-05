package com.brageast.blog.util;

import com.brageast.blog.entity.User;
import com.brageast.blog.service.UserService;
import com.brageast.blog.util.impl.GrantedAuthorityImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;

import java.util.ArrayList;

public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private UserService userService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String name = authentication.getName();
        User user = userService.findUser(name);
        if(user == null) throw new BadCredentialsException("没有这个用户");
        String BeforePassword = PasswordTools.decrypt(user.getPassword());
        String AfterPassword = authentication.getCredentials().toString();
        if(BeforePassword.equals(AfterPassword)) {
            ArrayList<GrantedAuthority> authorities = new ArrayList<>();
            authorities.add(new GrantedAuthorityImpl("admin"));
            Authentication auth = new UsernamePasswordAuthenticationToken(
                    user.getName(), BeforePassword, authorities
            );
            return auth;
        } else {
            throw new BadCredentialsException("密码错误");
        }
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.equals(UsernamePasswordAuthenticationToken.class);
    }
}
