package com.example.whiteboardbackend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.whiteboardbackend.entity.Message;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MessageRepository extends JpaRepository<Message,Long> {

    List<Message> findAllBySenderOrReceiver(String sender, String receiver);
    

    @Query("SELECT m FROM Message m WHERE (m.sender = :userUid AND m.receiver = :chosenUserUid) OR (m.sender = :chosenUserUid AND m.receiver = :userUid)")
    List<Message> findConversation(@Param("userUid") String userUid, @Param("chosenUserUid") String chosenUserUid);
}
