package com.example.whiteboardbackend.service;

import java.util.List;

import com.example.whiteboardbackend.entity.User;


public interface UserService {
    User saveUser(User user);
    User getUSer(String uid);
    List<User> getAllUsers();
}
