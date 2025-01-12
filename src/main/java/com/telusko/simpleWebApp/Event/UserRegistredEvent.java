package com.telusko.simpleWebApp.Event;

import com.telusko.simpleWebApp.model.User;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;

@Getter
public class UserRegistredEvent extends ApplicationEvent {
    private final User user;

    public UserRegistredEvent(Object source, User user){
        super(source);
        this.user = user;
    }
}
