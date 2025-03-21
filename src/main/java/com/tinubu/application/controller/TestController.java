package com.tinubu.application.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test")
public class TestController {

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello, World! Votre application fonctionne correctement.";
    }

    @GetMapping("/status")
    public String checkStatus() {
        return "Application is up and running!";
    }
}
