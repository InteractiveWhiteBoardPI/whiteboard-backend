package com.example.whiteboardbackend.service;

import com.example.whiteboardbackend.entity.Session;

import java.util.UUID;

public interface SessionService {
    public Session saveSession(Session session);
    Session getSessionById(UUID sessionId);

}
