package com.example.whiteboardbackend.controller;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class WebSocketController {

    @MessageMapping("/chat")
    @SendTo("/topic/messages")
    public String processMessage(String message) {
        System.out.println("Message: "+message);
        return message;
    }
}
