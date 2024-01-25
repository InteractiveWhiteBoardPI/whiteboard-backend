package com.example.whiteboardbackend.service;

import com.example.whiteboardbackend.entity.DeletedMessage;
import com.example.whiteboardbackend.entity.Message;

import java.util.List;

public interface MessageService {
    
    Message saveMessage(Message message);

    List<Message> getUserMessages(String userUid);

    void deleteMsg(DeletedMessage message);

    void deleteAllMessages(String UserId, String ChosenUserId);

}
