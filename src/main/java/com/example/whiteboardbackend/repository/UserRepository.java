package com.example.whiteboardbackend.repository;


import com.example.whiteboardbackend.entity.User;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {
    Optional<User> getUsersByUsername(String username);
}