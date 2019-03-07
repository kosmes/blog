package com.jineyne.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloViewController {
    @RequestMapping("/hello")
    public String index(Model model) {
        model.addAttribute("msg", "Hello, World!");
        return "hello";
    }
}
