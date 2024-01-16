package com.example.whiteboardbackend.service;

import java.util.List;

import com.example.whiteboardbackend.entity.DeletedMessage;
import com.example.whiteboardbackend.entity.Message;


public interface MessageService {
    

    public List<Message> getUserMessages(String userUid);

    public void deleteMsg(DeletedMessage message);

    public void deleteAllMessages(String userId, String chosenUserId);

    public Message saveMessage(Message message);

    public List<Message> getSessionMessages(String receiver);
    
}
