package com.example.whiteboardbackend.service;



import com.example.whiteboardbackend.entity.Session;
import com.example.whiteboardbackend.entity.Users;

public interface SessionService {
    public Session saveSession(Session session);
    public void joinSession(String sessionId, Users user) ;
    
}
