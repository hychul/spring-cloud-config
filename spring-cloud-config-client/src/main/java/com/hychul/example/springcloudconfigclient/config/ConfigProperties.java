package com.hychul.example.springcloudconfigclient.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties("msg")
public class ConfigProperties {
    private String hello;
    private String world;
}
