package com.hychul.example.springcloudconfigclient.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.cloud.context.refresh.ContextRefresher;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/manual-refresh")
@RequiredArgsConstructor
public class ManualRefreshController {

    private final ContextRefresher contextRefresher;

    @PostMapping
    public void refreshConfig() {
        contextRefresher.refresh();
    }
}
