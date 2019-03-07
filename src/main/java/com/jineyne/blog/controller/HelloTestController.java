package com.jineyne.blog.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloTestController {
    @RequestMapping("/")
    public String index() {
        return "Hello, World!";
    }
}
