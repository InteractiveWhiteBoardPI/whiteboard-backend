package com.example.whiteboardbackend.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.whiteboardbackend.entity.DeletedMessage;
import com.example.whiteboardbackend.entity.Message;
import com.example.whiteboardbackend.entity.entitypk.DeletedMessagePK;
import com.example.whiteboardbackend.repository.DeletedMessageRepository;
import com.example.whiteboardbackend.repository.MessageRepository;
import com.example.whiteboardbackend.service.MessageService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MessageServiceImp implements MessageService {
    @Autowired
    MessageRepository messageRepository;

    @Autowired
    DeletedMessageRepository deletedMessageRepository;


    @Override
    public Message saveMessage(Message message) {
        return messageRepository.save(message);
    }

   

    @Override
    public List<Message> getUserMessages(String userUid) {
        List<Message> messages = messageRepository.findAllBySenderOrReceiver(userUid, userUid);

        return messages.stream().filter(
                message ->
                        !deletedMessageRepository.existsById(new DeletedMessagePK(message.getId(), userUid))
        ).toList();
    }

    @Override
    public void deleteMsg(DeletedMessage message) {
        deletedMessageRepository.save(message);
    }

    @Override
    public void deleteAllMessages(String userId, String chosenUserId) {
        List<Message> conversation = messageRepository.findConversation(userId, chosenUserId);
        conversation.forEach(message -> {
            deletedMessageRepository.save(
                    new DeletedMessage(
                            new DeletedMessagePK(message.getId(), userId)
                    )
            );
        });
    }



    @Override
    public List<Message> getSessionMessages(String sessionUid) {
        return messageRepository.findByReceiver(sessionUid);
    }



    

 

}
