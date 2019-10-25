package com.xd.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class UserController {
    @RequestMapping("index")
    public String index(){
        return "index";
    }
    @RequestMapping("hello")
    public String hello() { return "hello"; }
}
