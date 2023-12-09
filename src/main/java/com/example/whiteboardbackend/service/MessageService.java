package com.example.whiteboardbackend.service;

import com.example.whiteboardbackend.entity.Message;
import java.util.List;
import java.util.Optional;

public interface MessageService {
    
    public Message saveMessage(Message message);
    public List<Message> getAll();
    public void deleteMessage(Long id);
    Optional<Message> findById(Long id);
    public Optional<List<Message>> findAllBySenderOrReceiver(String string, String receiver);
   
}
