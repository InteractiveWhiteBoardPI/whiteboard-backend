package com.example.whiteboardbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.whiteboardbackend.entity.Whiteboard;

import java.util.List;
import java.util.UUID;


public interface WhiteboardRepository extends JpaRepository<Whiteboard, UUID>{
    List<Whiteboard> findByOwnerUid(String owner_uid);
}
