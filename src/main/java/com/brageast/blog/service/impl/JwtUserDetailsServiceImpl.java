package com.brageast.blog.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class JwtUserDetailsServiceImpl /*implements UserDetailsService*/ {

    /*@Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        User user = userService.findUser(name);
        if(user == null) throw new UsernameNotFoundException(name + " 用户不存在");
//        List<SimpleGrantedAuthority> colle = user.getListPermissions().stream()
//                .map(Role::getRoleName)

        return null;
    }*/
}
