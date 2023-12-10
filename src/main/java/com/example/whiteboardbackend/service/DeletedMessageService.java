package com.example.whiteboardbackend.service;

import java.util.Optional;


import com.example.whiteboardbackend.entity.DeletedMessage;
import com.example.whiteboardbackend.entity.DeletedMessagePK;



public interface DeletedMessageService {
    public DeletedMessage deleteMsg(DeletedMessagePK message);
    public Optional<DeletedMessage> findByMessageIdAndUserId(Long messageId, String userId);

    public void deleteAllMessages(String user_id, String chosen_user_id);

    

}
