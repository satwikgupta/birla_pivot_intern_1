package com.ecommerce.E_Commerce.Controller;

import com.ecommerce.E_Commerce.Entity.User;
import com.ecommerce.E_Commerce.Service.UserService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/getUsers")
    public ResponseEntity<List<User>> getAllUsers(){
        return userService.getAllUsers();
    }

    @PostMapping("/addUser")
    public ResponseEntity<String> addUserToApp(@RequestBody User user){
        System.out.println("Received User: " + user);
        return userService.addUser(user);
    }
}
