package com.example.whiteboardbackend.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.whiteboardbackend.SessionRepository.SessionRepository;
import com.example.whiteboardbackend.entity.Session;
import com.example.whiteboardbackend.service.SessionService;


@Service
public class SessionServiceImp implements SessionService{

    @Autowired
    SessionRepository sessionRepository;

    @Override
    public Session saveSession(Session session) {
        return sessionRepository.save(session);
    }
    
}
