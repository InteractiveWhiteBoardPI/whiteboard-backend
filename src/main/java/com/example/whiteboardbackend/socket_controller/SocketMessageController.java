package com.example.whiteboardbackend.socket_controller;

import com.example.whiteboardbackend.entity.MessageFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;


import com.example.whiteboardbackend.entity.MessageText;
import com.example.whiteboardbackend.service.MessageService;

@Controller
@CrossOrigin(origins = "http://localhost:3000")
public class SocketMessageController {
    @Autowired
    SimpMessagingTemplate simpMessagingTemplate;

    @Autowired
    MessageService messageService;

    @MessageMapping("/private-message")
    public MessageText receiveMessage(@Payload MessageText message){
        simpMessagingTemplate.convertAndSendToUser(message.getReceiver(),"/private",message);
        return message;
    }

    @MessageMapping("/private-message/file")
    public MessageFile receiveFileMessage(@Payload MessageFile fileMessage){
        simpMessagingTemplate.convertAndSendToUser(fileMessage.getReceiver(),"/private",fileMessage);
        System.out.println("fileMessage: "+ fileMessage);
        return fileMessage;
    }
}
