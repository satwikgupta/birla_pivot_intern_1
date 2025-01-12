package com.telusko.simpleWebApp.controller;

import com.telusko.simpleWebApp.model.User;
import com.telusko.simpleWebApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {

    @Autowired
    UserService userService;

    @PostMapping("/register")
    public User RegisterUser(@RequestBody User regUser){
        return userService.registerUser(regUser);
    }
}
