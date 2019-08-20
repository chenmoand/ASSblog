package com.brageast.blog;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class BlogApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlogApplication.class, args);

        System.out.println(
                "　　＃＃＃＃＃＃　　　＃＃＃＃＃＃＃＃＃＃　　　＃＃＃＃＃＃＃＃＃　　　＃＃＃＃　　　＃＃＃　　　＃＃＃＃　　　　＃＃＃　　　　　＃＃＃＃＃　　\n" +
                "　＃＃＃　　＃＃　　　　　＃＃　　　＃　　　　　　　＃＃　　＃＃＃　　　　　＃＃＃　　　＃　　　　　＃＃＃　　　　＃＃　　　　　＃＃＃　＃＃＃　\n" +
                "　＃＃　　　　＃＃　　　　＃　　　　＃　　　　　　　＃　　　＃＃＃　　　　　＃＃＃　　　＃　　　　　　＃＃＃　　＃＃＃　　　　　＃＃　　　＃＃　\n" +
                "　＃＃　　　　　　　　　　＃　　　　＃　　　　　　　＃　　　＃　　　　　　　＃　＃＃　　＃　　　　　　＃＃＃　　＃＃＃　　　　　＃＃　　　＃＃＃\n" +
                "＃＃＃　　　　　　　　　　＃＃＃＃＃＃　　　　　　　＃＃＃＃＃　　　　　　　＃　＃＃＃　＃　　　　　　＃＃＃＃　＃　＃　　　　＃＃＃　　　＃＃＃\n" +
                "＃＃＃　　　　　　　　　　＃　　　　＃　　　　　　　＃　　　＃　　　　　　　＃　　＃＃＃＃　　　　　　＃　＃＃＃＃　＃　　　　　＃＃　　　＃＃＃\n" +
                "　＃＃　　　　＃＃　　　　＃　　　　＃　　　　　　　＃　　　＃　＃　　　　　＃　　　＃＃＃　　　　　　＃　＃＃＃　　＃　　　　　＃＃　　　＃＃　\n" +
                "　＃＃＃　　＃＃＃　　　　＃　　　　＃　　　　　　　＃＃　　　＃＃　　　　　＃　　　　＃＃　　　　　　＃　　＃＃　　＃　　　　　＃＃　　＃＃＃　\n" +
                "　　＃＃＃＃＃＃　　　＃＃＃＃＃＃＃＃＃＃　　　＃＃＃＃＃＃＃＃＃　　　　＃＃＃＃　　　＃　　　　＃＃＃＃　＃＃＃＃＃＃　　　　　＃＃＃＃＃　　"
        );
        log.info("项目已经成功运行,祝你玩得愉快!");
    }

    /*@Bean
    public Connector connector(){
        Connector connector=new Connector("org.apache.coyote.http11.Http11NioProtocol");
        connector.setScheme("http");
        connector.setPort(80);
        connector.setSecure(false);
        connector.setRedirectPort(443);
        return connector;
    }

    @Bean
    public TomcatServletWebServerFactory tomcatServletWebServerFactory(Connector connector){
        TomcatServletWebServerFactory tomcat=new TomcatServletWebServerFactory(){
            @Override
            protected void postProcessContext(Context context) {
                SecurityConstraint securityConstraint=new SecurityConstraint();
                securityConstraint.setUserConstraint("CONFIDENTIAL");
                SecurityCollection collection=new SecurityCollection();
                collection.addPattern("/*");
                securityConstraint.addCollection(collection);
                context.addConstraint(securityConstraint);
            }
        };
        tomcat.addAdditionalTomcatConnectors(connector);
        return tomcat;
    }*/

}
