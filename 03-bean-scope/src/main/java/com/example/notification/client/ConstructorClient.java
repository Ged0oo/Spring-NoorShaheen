package com.example.notification.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.notification.service.MessageService;

@Component
public class ConstructorClient {
	private final MessageService messageService;
	
	@Autowired
    public ConstructorClient(MessageService messageService) {
        this.messageService = messageService;
    }

    public void processNotification() {
        System.out.println("Constructor Client: " + messageService.getMessage());
    }
}
