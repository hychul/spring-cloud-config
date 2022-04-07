package com.hychul.example.springcloudconfigclient.service;


import com.hychul.example.springcloudconfigclient.config.ConfigProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.context.scope.refresh.RefreshScopeRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Service
@RefreshScope
@RequiredArgsConstructor
public class DynamicPropertyConfigService {

    private final ConfigProperties configProperties;

    @PostConstruct
    public void postConstruct() {
        // TODO: Add logics to run when refresh config
        System.out.println("[PropertyConfigService] post construct");
    }

    @EventListener(RefreshScopeRefreshedEvent.class)
    public void onRefresh(RefreshScopeRefreshedEvent event) {
        // For @PostConstruct on refresh event
    }

    public Map<String, String> getConfig() {
        Map<String, String> map = new HashMap<>();
        map.put("hello", configProperties.getHello());
        map.put("world", configProperties.getWorld());
        return map;
    }
}
