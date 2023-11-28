package com.example.whiteboardbackend.repository;


import com.example.whiteboardbackend.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users,String> {

}