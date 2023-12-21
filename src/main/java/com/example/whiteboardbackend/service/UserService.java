package com.example.whiteboardbackend.service;

import java.util.List;



import com.example.whiteboardbackend.entity.Users;

public interface UserService {
    public Users saveUser(Users user);
    public Users getUSer(String uid);
    public List<Users> getAllUsers();
    public Users getUserByUsername(String userName);
}
