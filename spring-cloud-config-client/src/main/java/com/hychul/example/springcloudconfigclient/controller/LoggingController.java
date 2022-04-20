package com.hychul.example.springcloudconfigclient.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/logging")
@RequiredArgsConstructor
public class LoggingController {

    @GetMapping("/log")
    public String log() {

        log.trace("trace msg");
        log.debug("debug msg");
        log.info("info msg");
        log.warn("info msg");
        log.error("info msg");

        return "OK";
    }
}
