package com.test.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

public class DispatchController {
    @RequestMapping("/login")
    public String showLogin(){
        return "/login";
    }
    @GetMapping("/showJwt")
    public String showJwt(){
        return "showJwt";
    }
    @GetMapping("/index")
    public String index(){
        return "index";
    }
}

