package com.hychul.example.springcloudconfigclient.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.context.scope.refresh.RefreshScopeRefreshedEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;

import javax.annotation.PostConstruct;

@Configuration
@RefreshScope
public class RefreshConfig {

    @PostConstruct
    public void postConstruct() {
        System.out.println("[RefreshConfig] post construct");
        // TODO: Add logics to reinitialize bean instances
    }

    @EventListener(RefreshScopeRefreshedEvent.class)
    public void onRefresh(RefreshScopeRefreshedEvent event) {
        // For @PostConstruct on refresh event
    }

    @Bean(name="stringBean1")
    public String getStringBean1(ConfigProperties configProperties) {
        return configProperties.getHello() + configProperties.getWorld();
    }

    @Bean(name="stringBean2")
    @ConditionalOnProperty(name = {"msg.hello", "msg.world"})
    public String getStringBean2(@Value("${msg.hello}") String hello, @Value("${msg.world}") String world) {
        return hello + world;
    }
}
