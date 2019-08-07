package com.brageast.blog.service.impl;

import com.brageast.blog.entity.User;
import com.brageast.blog.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.management.relation.Role;
import java.util.List;

@Slf4j
@Service
public class JwtUserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        User user = userService.findUser(name);
        if(user == null) throw new UsernameNotFoundException(name + " 用户不存在");
//        List<SimpleGrantedAuthority> colle = user.getListPermissions().stream()
//                .map(Role::getRoleName)

        return null;
    }
}
