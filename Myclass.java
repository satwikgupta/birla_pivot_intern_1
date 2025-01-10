package com.example.MyFirstProject;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Myclass {

    @GetMapping("kishan")
    public String sayHello()
    {
        return "Hi, Kishan this side";
    }
}
