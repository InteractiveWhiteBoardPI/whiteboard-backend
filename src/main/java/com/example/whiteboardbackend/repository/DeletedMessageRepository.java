package com.example.whiteboardbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.whiteboardbackend.entity.DeletedMessage;
import com.example.whiteboardbackend.entity.entitypk.DeletedMessagePK;

public interface DeletedMessageRepository extends JpaRepository<DeletedMessage,DeletedMessagePK> {
}
