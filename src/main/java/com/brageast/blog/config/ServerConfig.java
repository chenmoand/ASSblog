package com.brageast.blog.config;

import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ServerConfig implements ApplicationListener<WebServerInitializedEvent> {
    private int port; // 获取服务器端口
    @Override
    public void onApplicationEvent(@NotNull WebServerInitializedEvent event) {
        this.port = event.getWebServer().getPort();
    }
    public int getPort() {
        return port;
    }
}
