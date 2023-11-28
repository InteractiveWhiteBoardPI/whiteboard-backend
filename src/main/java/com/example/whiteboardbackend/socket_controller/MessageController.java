package com.example.whiteboardbackend.socket_controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import com.example.whiteboardbackend.entity.Message;

@Controller
public class MessageController {


    @Autowired
    SimpMessagingTemplate simpMessagingTemplate;
    
    @MessageMapping("/private-message")
    public Message receiveMessage(@Payload Message message){
        simpMessagingTemplate.convertAndSendToUser(message.getReceiver(),"/private",message);
        return message;
    }
}
