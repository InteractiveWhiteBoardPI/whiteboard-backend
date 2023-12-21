package com.example.whiteboardbackend.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import com.example.whiteboardbackend.SessionRepository.SessionRepository;
import com.example.whiteboardbackend.entity.Session;
import com.example.whiteboardbackend.entity.Users;
import com.example.whiteboardbackend.service.SessionService;


@Service
public class SessionServiceImp implements SessionService{

    @Autowired
    SessionRepository sessionRepository;
     @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @Override
    public Session saveSession(Session session) {
        return sessionRepository.save(session);
    }

    @Override
    public void joinSession(String sessionId,Users userName) {
        messagingTemplate.convertAndSend("/topic/session/" + sessionId, "New participant joined");
    }
    
}
