package com.example.whiteboardbackend.socket_controller;

import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import com.example.whiteboardbackend.config.SignalingMessage;


@Controller
public class WebRTCController {

    private final SimpMessagingTemplate messagingTemplate;

    public WebRTCController(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    @MessageMapping("/session/{sessionId}/webrtc")
    public String handleWebRTCMessage(@DestinationVariable String sessionId, @Payload SignalingMessage message) {
        System.out.println(sessionId);
        messagingTemplate.convertAndSend("/session/" + sessionId + "/webrtc", message);
        return sessionId;
    };
}