package com.example.firstProject.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class firstApiController {

    @GetMapping("/api/hello")
    public String hello() {
        return "hello world!";
    }
}
