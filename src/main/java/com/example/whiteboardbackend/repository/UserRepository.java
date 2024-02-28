package com.example.whiteboardbackend.repository;


import com.example.whiteboardbackend.entity.User;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User,String> {
    @Modifying
    @Query("UPDATE User u SET u.joinedSession = null WHERE u.uid = :userId AND u.joinedSession.uid = :sessionId")
    public void removeMemberFromSession(String userId, UUID sessionId);
}