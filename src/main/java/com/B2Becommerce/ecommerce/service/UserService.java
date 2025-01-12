package com.B2Becommerce.ecommerce.service;


import com.B2Becommerce.ecommerce.model.Order;
import com.B2Becommerce.ecommerce.model.User;
import com.B2Becommerce.ecommerce.repo.UserRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    public String login(User user) throws Exception{
        User userInDb = userRepo.findByEmail(user.getEmail()).orElse(null);
        if(userInDb==null) throw new Exception("User Not Found");
        else if(userInDb.getPassword().equals(user.getPassword())){
            String jwtToken = "ejfhwjhfurfgiuwgf";
            return jwtToken;
        }
        return null;
    }

    public User register(User user){
        System.out.println(user.toString());

        return userRepo.save(user);
    }

    @Transactional
    public void addUserOrders(String userEmail, Order newOrder) throws Exception {
        // Fetch the user by email
        User userInDB = userRepo.findByEmail(userEmail).orElseThrow(
                () -> new Exception("User not found with email: " + userEmail)
        );

        // Ensure the new order is not null
        if (newOrder == null) {
            throw new Exception("Order cannot be null or empty");
        }

        // Associate the order with the user
        newOrder.setUser(userInDB);

        // Add the order to the user's orders list (but do not save here)
        userInDB.getOrders().add(newOrder);
    }


    public List<User> getAll(){
        return userRepo.findAll();
    }

}
