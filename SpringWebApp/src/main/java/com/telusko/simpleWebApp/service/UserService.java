package com.telusko.simpleWebApp.service;

import com.telusko.simpleWebApp.Event.UserRegistredEvent;
import com.telusko.simpleWebApp.model.User;
import com.telusko.simpleWebApp.repository.IUserRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private IUserRepo userRepo;

    @Autowired
    private ApplicationEventPublisher eventPublisher;

    @Transactional
    public User registerUser(User user){
        User savedUser = userRepo.save(user);

        //publish event after registration
        eventPublisher.publishEvent(new UserRegistredEvent(this, savedUser));
        return savedUser;
    }

}
