package com.brageast.blog.filter;

import com.brageast.blog.entity.User;
import com.brageast.blog.service.UserService;
import com.brageast.blog.util.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@Slf4j
//@Component
public class JwtTokenFilter extends OncePerRequestFilter {

    @Autowired
    private UserDetailsService UserDetailsService;
    @Autowired
    private UserService userService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
        String authHeader = request.getHeader(JwtUtil.HEADER_STRING); // 获得TOKEN
        if(authHeader == null && authHeader.startsWith(JwtUtil.TOKEN_PREFIX)) {
            final String token = authHeader.substring(JwtUtil.TOKEN_PREFIX.length());
            String name = JwtUtil.getTokeSubject(token);
            if(name != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                User user = userService.findUser(name);
                if(JwtUtil.isTokenExpired(token) && user != null ) {
                    // emmm
                }
            }
        }
        chain.doFilter(request, response);
    }

}
