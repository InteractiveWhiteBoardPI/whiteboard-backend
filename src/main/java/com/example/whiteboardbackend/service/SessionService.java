package com.example.whiteboardbackend.service;

import com.example.whiteboardbackend.entity.Session;
import com.example.whiteboardbackend.entity.User;

import java.util.List;
import java.util.UUID;

import java.util.UUID;

public interface SessionService {
    public Session saveSession(Session session);
    Session getSessionById(UUID sessionId);


    public Session getSession(String name, String password);

    public void addMember(User member, UUID uuid);

    public List<User> getMembers(UUID sessionId);
}
