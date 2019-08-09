package com.brageast.blog.service.impl;

import com.brageast.blog.entity.Group;
import com.brageast.blog.entity.User;
import com.brageast.blog.entity.jwt.JwtUser;
import com.brageast.blog.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class JwtUserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        User user = userService.findUser(name);
        if(user == null) throw new UsernameNotFoundException(name + " 用户不存在");
        List<SimpleGrantedAuthority> colle = user.getGroups().stream()
                .map(Group::getName)
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());

        return new JwtUser(user.getName(), user.getPassword(), colle);
    }
}
