package com.example.notification.service;

import org.springframework.context.annotation.Scope;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.stereotype.Service;
import jakarta.annotation.PostConstruct;

@Service
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class EmailService implements MessageService {

    public EmailService() {
        System.out.println(">> EmailService Constructor: New Instance Created!");
    }

    @Override
    public String getMessage() {
        return "Notification via Prototype Bean";
    }

    @PostConstruct
    public void init() {
        System.out.println(">> EmailService: @PostConstruct called");
    }
}