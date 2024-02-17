package com.example.whiteboardbackend.socket_controller;

import com.example.whiteboardbackend.pojo.Notification;
import com.example.whiteboardbackend.pojo.UserMedia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

@Controller
public class NotificationController {
    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @MessageMapping("/notification/notify-user/{from}/{to}")
    public void notifyUser(@Payload Notification notification, @DestinationVariable String from, @DestinationVariable String to) {
        System.out.println("im here");
        messagingTemplate.convertAndSend("/user/" + to + "/queue/notifications", notification);
        System.out.println("im here");

    }
}