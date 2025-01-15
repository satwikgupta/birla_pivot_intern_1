package com.telusko.simpleWebApp.Listener;

import com.telusko.simpleWebApp.Event.UserRegistredEvent;
import com.telusko.simpleWebApp.model.User;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
public class WelcomeEmailListener {

    @TransactionalEventListener
    public void handleUserRegisteredEvent(UserRegistredEvent event){
        User user = event.getUser();

        //Simulate sending email
        System.out.println("Sending Welcome Email to " + user.getEmail());
    }
}
