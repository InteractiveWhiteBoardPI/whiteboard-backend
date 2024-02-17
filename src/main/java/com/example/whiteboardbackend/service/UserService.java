package com.example.whiteboardbackend.service;

import java.util.List;

import com.example.whiteboardbackend.entity.User;

public interface UserService {
    public User saveUser(User user);
    public User getUSer(String uid);
    public List<User> getAllUsers();
    public boolean userExist(String uid);
}
