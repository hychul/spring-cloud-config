package com.hychul.example.springcloudconfigclient.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class StaticValueConfigService {

    @Value("${msg.hello}")
    private String hello;
    @Value("${msg.world}")
    private String world;

    public Map<String, String> getConfig() {
        Map<String, String> map = new HashMap<>();
        map.put("hello", hello);
        map.put("world", world);
        return map;
    }
}
