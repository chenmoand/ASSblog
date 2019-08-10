package com.brageast.blog.filter;

import com.brageast.blog.config.ServerConfig;
import com.brageast.blog.util.JwtUtil;
import com.brageast.blog.util.entity.ResultState;
import com.brageast.blog.util.entity.State;
import io.jsonwebtoken.ExpiredJwtException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@Component
public class JwtTokenFilter extends OncePerRequestFilter {

    @Autowired
    private ServerConfig serverConfig;
    @Qualifier("userDetailsServiceImpl")
    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
        final int port = serverConfig.getPort();
        String authHeader = request.getHeader(JwtUtil.HEADER_STRING); // 获得TOKEN
        try {
            if(authHeader != null && authHeader.startsWith(JwtUtil.TOKEN_PREFIX)) {
                final String token = authHeader.substring(JwtUtil.TOKEN_PREFIX.length());
                String name = JwtUtil.getTokeSubject(token);
                if(name != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                    UserDetails userDetails = userDetailsService.loadUserByUsername(name);
                    if(JwtUtil.isExistToken(token) && JwtUtil.isTokenExpired(token) && userDetails != null ) {
                        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                        authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                        SecurityContextHolder.getContext().setAuthentication(authentication);
                    }
                }
            }
            chain.doFilter(request, response);
        } catch (ExpiredJwtException e) { //token过期
            response.addHeader("Access-Control-Allow-origin","http://localhost:"+port);
            response.setContentType("application/json;charset=utf-8");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(new ResultState(State.EXPIRED, "抱歉，您的登录信息已过期，请重新登录").toJsonString());
        }
    }

}
