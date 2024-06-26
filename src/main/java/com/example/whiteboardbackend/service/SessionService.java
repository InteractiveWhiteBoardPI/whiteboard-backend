package com.example.whiteboardbackend.service;

import com.example.whiteboardbackend.entity.Session;
import com.example.whiteboardbackend.entity.User;

import java.util.List;
import java.util.UUID;

public interface SessionService {
    Session saveSession(Session session);

    Session getSession(String name, String password);
    Session getSession(UUID sessionId);

    void addMember(User member, UUID uuid);

    List<User> getMembers(UUID sessionId);

    public boolean isSessionExist(UUID sessionId);
    public String getSessionName(UUID sessionId);


}