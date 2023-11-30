package com.example.whiteboardbackend.service.imp;

import com.example.whiteboardbackend.entity.Users;
import com.example.whiteboardbackend.exception.UserNotFoundException;
import com.example.whiteboardbackend.repository.UserRepository;
import com.example.whiteboardbackend.service.UserService;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImp implements UserService{

    @Autowired
    UserRepository userRepository;


    @Override
    public Users saveUser(Users user) {
        return userRepository.save(user);
    }

    @Override
    public Users getUSer(String uid) {
        Optional<Users> user = userRepository.findById(uid);
        if(user.isPresent()) return user.get();
        throw new UserNotFoundException(uid);
    }

    @Override
    public List<Users> getAllUsers() {
        return (List<Users>) userRepository.findAll();
    }

    
}
