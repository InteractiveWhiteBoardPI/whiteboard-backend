package com.example.whiteboardbackend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.whiteboardbackend.entity.DeletedMessage;
import com.example.whiteboardbackend.entity.DeletedMessagePK;

public interface DeletedMessageRepository extends JpaRepository<DeletedMessage,DeletedMessagePK> {
    Optional<DeletedMessage> findByDeletedMessagePK(DeletedMessagePK deletedMessagePK);
    
}
