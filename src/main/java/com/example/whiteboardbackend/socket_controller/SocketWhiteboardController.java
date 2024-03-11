package com.example.whiteboardbackend.socket_controller;

import com.example.whiteboardbackend.entity.LineData;
import com.example.whiteboardbackend.repository.LineDataRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class SocketWhiteboardController {
    @Autowired
    SimpMessagingTemplate simpMessagingTemplate;

    @Autowired
    private LineDataRepository lineDataRepository;

    @MessageMapping("/whiteboard/draw")
    public void handleDrawing(@Payload LineData lineData) {
        lineDataRepository.save(lineData);
        simpMessagingTemplate.convertAndSendToUser(
                lineData
                        .getSession()
                        .getUid()
                        .toString(),
                "/draw",
                lineData);
    }

    @MessageMapping("/whiteboard/prev")
    public void handlePrev(@Payload LineData lineData) {
        lineDataRepository.deleteById(lineData.getId());
        simpMessagingTemplate.convertAndSendToUser(
                lineData
                        .getSession()
                        .getUid()
                        .toString(),
                "/prev",
                lineData);
    }
}