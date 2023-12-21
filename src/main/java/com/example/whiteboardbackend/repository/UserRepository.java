package com.example.whiteboardbackend.repository;


import com.example.whiteboardbackend.entity.Users;

import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


public interface UserRepository extends JpaRepository<Users,String> {
    Optional<Users> getUsersByUsername(String username);   
    Users  getUserByUsername(String username);
}