package com.example.whiteboardbackend.service;

import com.example.whiteboardbackend.entity.Users;

public interface UserService {
    public Users saveUser(Users user);

    public Users getUSer(String uid);

}
