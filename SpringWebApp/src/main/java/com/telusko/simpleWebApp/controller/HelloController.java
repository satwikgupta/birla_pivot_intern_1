package com.telusko.simpleWebApp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //will same as @ResponseBody
public class HelloController {

    @RequestMapping("/")
    public String greet(){
        return "Welcome to spring !";
    }

    @RequestMapping("/about")
    public String aboutus(){
        return "This is what we are.";
    }
}
