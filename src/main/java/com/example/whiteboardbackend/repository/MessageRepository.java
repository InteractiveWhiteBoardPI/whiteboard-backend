package com.example.whiteboardbackend.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.whiteboardbackend.entity.Message;

public interface MessageRepository extends JpaRepository<Message,Long> {
    
    Optional<List<Message>> findAllBySenderOrReceiver(String sender, String receiver);
    
    Optional<List<Message>> findAllBySenderAndReceiver(String sender, String receiver);
}
