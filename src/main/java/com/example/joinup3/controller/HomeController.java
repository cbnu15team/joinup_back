package com.example.joinup3.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/") // 기본 경로 매핑
    public String home() {
        return "Welcome to the Spring Boot Application!";
    }
}
