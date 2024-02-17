package com.example.whiteboardbackend.service.imp;

import com.example.whiteboardbackend.entity.User;
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
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUSer(String uid) {
        Optional<User> user = userRepository.findById(uid);
        if(user.isPresent()) return user.get();
        throw new UserNotFoundException(uid);
    }

    @Override
    public List<User> getAllUsers() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public boolean userExist(String uid) {
        return userRepository.existsById(uid);
    }


}
