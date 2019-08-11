package com.brageast.blog.config;

import com.brageast.blog.filter.GustAccessDenyFilter;
import com.brageast.blog.filter.JwtTokenFilter;
import com.brageast.blog.filter.UserAccessDenyFilter;
import com.brageast.blog.util.MyPasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsUtils;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired // 自己的密码加密器
    private MyPasswordEncoder myPasswordEncoder;
    @Autowired // 用户无法访问
    private UserAccessDenyFilter rewriteAccessDenyFilter;
    @Autowired // 游客无法访问
    private GustAccessDenyFilter gustAccessDenyFilter;
    @Autowired
    private JwtTokenFilter jwtTokenFilter;

    @Qualifier("userDetailsServiceImpl")
    @Autowired
    private UserDetailsService userDetailsService;


    protected void configure(HttpSecurity http) throws Exception {
        // 基于token，不需要csrf
        http.csrf().disable()
                // 基于token，不需要session
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .authorizeRequests() // 开始设置权限
                .antMatchers("/druid/**").anonymous()
                .antMatchers("/api/user/**").permitAll()
                // 除上面外的所有请求全部放开
                .anyRequest().authenticated();

        http.addFilterBefore(jwtTokenFilter, UsernamePasswordAuthenticationFilter.class);

        // 无权限的走这里
        http.exceptionHandling().accessDeniedHandler(rewriteAccessDenyFilter)
                .and().exceptionHandling().authenticationEntryPoint(gustAccessDenyFilter);

        // 放行所有Preflight request
        // 意义在于https://developer.mozilla.org/zh-CN/docs/Glossary/Preflight_request
        http.authorizeRequests().requestMatchers(CorsUtils::isPreFlightRequest).permitAll();
    }

    @Autowired
    public void configureAuthentication(AuthenticationManagerBuilder authenticationManagerBuilder)throws Exception{
        authenticationManagerBuilder.userDetailsService(this.userDetailsService).passwordEncoder(myPasswordEncoder);
    }


}
