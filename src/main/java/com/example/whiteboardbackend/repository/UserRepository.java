package com.example.whiteboardbackend.repository;


import com.example.whiteboardbackend.entity.Users;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users,String> {
    Optional<Users> getUsersByUsername(String username);   
}