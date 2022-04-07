package com.hychul.example.springcloudconfigclient.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.context.scope.refresh.RefreshScopeRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

/**
 * To refresh config property manually, call `/actuator/refresh` POST api
 */
@Service
@RefreshScope
public class DynamicValueConfigService {

    @Value("${msg.hello}")
    private String hello;
    @Value("${msg.world}")
    private String world;

    @PostConstruct
    public void postConstruct() {
        // TODO: Add logics to run when refresh config
        System.out.println("[DynamicConfigService] post construct");
    }

    @EventListener(RefreshScopeRefreshedEvent.class)
    public void onRefresh(RefreshScopeRefreshedEvent event) {
        // For @PostConstruct on refresh event
    }

    public Map<String, String> getConfig() {
        Map<String, String> map = new HashMap<>();
        map.put("hello", hello);
        map.put("world", world);
        return map;
    }
}
