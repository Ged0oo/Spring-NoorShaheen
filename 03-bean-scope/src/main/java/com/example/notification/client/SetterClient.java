package com.example.notification.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.notification.service.MessageService;

@Component
public class SetterClient {
	private MessageService messageService;
	
	@Autowired
    public void setMessageService(MessageService messageService) {
        this.messageService = messageService;
    }

    public void processNotification() {
        System.out.println("Setter Client: " + messageService.getMessage());
    }
}
