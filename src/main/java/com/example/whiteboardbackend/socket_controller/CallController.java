package com.example.whiteboardbackend.socket_controller;

import com.example.whiteboardbackend.pojo.PeerId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import com.example.whiteboardbackend.pojo.Call;
import com.example.whiteboardbackend.pojo.UserMedia;


@Controller
public class CallController {
    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @MessageMapping("/session/user-join/{sessionId}")
    public void userJoined(@Payload PeerId peerId, @DestinationVariable String sessionId ) {
        messagingTemplate.convertAndSendToUser(sessionId,"/session/user-joined", peerId);
    }
    @MessageMapping("/session/toggle-media/{from}/{to}")
    public void toggleMedia(@Payload UserMedia media, @DestinationVariable String from, @DestinationVariable String to) {
        media.setUserId(from);
        messagingTemplate.convertAndSendToUser(to,"/session/toggle-media", media);
    }
    @MessageMapping("/session/user-leave/{sessionId}")
    public void userLeaved(@Payload String userId, @DestinationVariable String sessionId ) {
        messagingTemplate.convertAndSendToUser(sessionId,"/session/user-left", userId);
    }
}