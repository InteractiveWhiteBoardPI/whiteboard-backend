package com.example.whiteboardbackend.service.imp;

import com.example.whiteboardbackend.entity.User;
import com.example.whiteboardbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.whiteboardbackend.entity.Session;
import com.example.whiteboardbackend.repository.SessionRepository;
import com.example.whiteboardbackend.service.SessionService;

import java.util.List;
import java.util.UUID;


@Service
public class SessionServiceImp implements SessionService{

    @Autowired
    SessionRepository sessionRepository;

    @Autowired
    UserService userService;

    @Override
    public Session saveSession(Session session) {
        return sessionRepository.save(session);
    }

    @Override
    public Session getSession(String name, String password) {
        return sessionRepository.findByNameAndPassword(name, password);
    }

    @Override
    public void addMember(User member, UUID uuid) {
        sessionRepository
                .findById(uuid)
                .ifPresent(value -> {
                    member.setJoinedSession(value);
                    userService.saveUser(member);
                });
    }

    @Override
    public List<User> getMembers(UUID sessionId) {
        return sessionRepository
                .findById(sessionId)
                .map(Session::getMembers)
                .orElse(null);
    }

    @Override  
    public boolean isSessionExist(UUID sessionId) {
        return sessionRepository.existsById(sessionId);
    }

    @Override
    public String getSessionName(UUID sessionId) {
        return sessionRepository
                .findById(sessionId)
                .map(Session::getName)
                .orElse(null);
    }

   

    
}
