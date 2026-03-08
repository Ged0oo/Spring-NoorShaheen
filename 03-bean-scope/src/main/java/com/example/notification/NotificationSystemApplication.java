package com.example.notification;

import com.example.notification.service.MessageService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class NotificationSystemApplication {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(NotificationSystemApplication.class, args);

        System.out.println("--- Requesting Bean 1 ---");
        MessageService service1 = context.getBean(MessageService.class);

        System.out.println("--- Requesting Bean 2 ---");
        MessageService service2 = context.getBean(MessageService.class);

        boolean isSame = (service1 == service2);
        System.out.println("Are they the same instance? " + isSame);
    }
}