package com.brageast.blog.config;

import com.brageast.blog.shiro.CustomRealm;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.config.DefaultShiroFilterChainDefinition;
import org.apache.shiro.spring.web.config.ShiroFilterChainDefinition;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class ShiroConfig {

    @Bean
    public Realm realm() {
        return new CustomRealm();
    }
    @Bean
    public static DefaultAdvisorAutoProxyCreator getDefaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator creator = new DefaultAdvisorAutoProxyCreator();
        /*
         *  我借鉴的Github的CaiBaoHong/elegant-shiro-boot
         *  他说这里如果不这样做会有bug有Bug
         */
        creator.setUsePrefix(true);
        return creator;
    }
    @Bean
    public ShiroFilterChainDefinition shiroFilterChainDefinition() {
        DefaultShiroFilterChainDefinition chainDefinition = new DefaultShiroFilterChainDefinition();
        chainDefinition.addPathDefinition("/**", "anon");
        return chainDefinition;
    }

}
