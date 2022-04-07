package com.hychul.example.springcloudconfigclient.controller;

import com.hychul.example.springcloudconfigclient.service.DynamicValueConfigService;
import com.hychul.example.springcloudconfigclient.service.DynamicPropertyConfigService;
import com.hychul.example.springcloudconfigclient.service.StaticValueConfigService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/config")
@RequiredArgsConstructor
public class ConfigController {

    private final StaticValueConfigService staticValueConfigService;
    private final DynamicValueConfigService dynamicValueConfigService;
    private final DynamicPropertyConfigService dynamicPropertyConfigService;
    private final String stringBean1;
    private final String stringBean2;

    @GetMapping("/static")
    public Object getConfigFromStatic() {
        return staticValueConfigService.getConfig();
    }

    @GetMapping("/dynamic")
    public Object getConfigFromDynamic() {
        return dynamicValueConfigService.getConfig();
    }

    @GetMapping("/property")
    public Object getConfigFromProperty() {
        return dynamicPropertyConfigService.getConfig();
    }

    @GetMapping("/string-bean-1")
    public String getConfigFromStaticBean() {
        return stringBean1;
    }

    @GetMapping("/string-bean-2")
    public String getConfigFromDynamicBean() {
        return stringBean2;
    }
}
