package com.example.whiteboardbackend.service;

import com.example.whiteboardbackend.entity.DeletedMessage;
import com.example.whiteboardbackend.entity.Message;

import java.util.List;

public interface MessageService {
    
    public Message saveMessage(Message message);

    public List<Message> getUserMessages(String userUid);

    public void deleteMsg(DeletedMessage message);

    public void deleteAllMessages(String UserId, String ChosenUserId);

}
