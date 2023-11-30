package com.example.whiteboardbackend.SessionRepository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.whiteboardbackend.entity.Session;

public interface SessionRepository extends JpaRepository<Session, UUID> {

}

