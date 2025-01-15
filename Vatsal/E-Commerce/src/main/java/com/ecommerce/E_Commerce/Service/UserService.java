package com.ecommerce.E_Commerce.Service;

import com.ecommerce.E_Commerce.Entity.User;
import com.ecommerce.E_Commerce.Repository.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    UserDAO userDAO;

    public ResponseEntity<List<User>> getAllUsers() {
        try{
            return new ResponseEntity<>(userDAO.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> addUser(User user) {
        System.out.println("User to be saved: " + user);
        userDAO.save(user);
        return new ResponseEntity<>("Successfully Added User to Application", HttpStatus.CREATED);
    }
}
