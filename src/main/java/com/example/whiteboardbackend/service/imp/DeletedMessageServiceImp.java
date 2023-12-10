package com.example.whiteboardbackend.service.imp;

import java.util.Optional;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.whiteboardbackend.entity.DeletedMessage;
import com.example.whiteboardbackend.entity.DeletedMessagePK;
import com.example.whiteboardbackend.entity.Message;
import com.example.whiteboardbackend.repository.DeletedMessageRepository;
import com.example.whiteboardbackend.repository.MessageRepository;
import com.example.whiteboardbackend.service.DeletedMessageService;

@Service
public class DeletedMessageServiceImp implements DeletedMessageService {

    @Autowired
    DeletedMessageRepository deletedMessageRepository;

    @Autowired
    MessageRepository messageRepository;

    @Override
    public DeletedMessage deleteMsg(DeletedMessagePK message) {
        DeletedMessage deletedMessage = new DeletedMessage(message);
        return deletedMessageRepository.save(deletedMessage);
    }

    @Override
    public Optional<DeletedMessage> findByMessageIdAndUserId(Long messageId, String userId) {
        DeletedMessagePK deletedMessagePK = new DeletedMessagePK();
        deletedMessagePK.setMessageId(messageId);
        deletedMessagePK.setUserId(userId);
        return deletedMessageRepository.findByDeletedMessagePK(deletedMessagePK);
    }

    @Override
    public void deleteAllMessages(String user_id, String chosen_user_id) {
        List<Message> msgs1 = new ArrayList<>();
        List<Message> msgs2 = new ArrayList<>();
        DeletedMessage deletedMessage1 = new DeletedMessage();
        DeletedMessage deletedMessage2 = new DeletedMessage();
        DeletedMessagePK deletedMessagePK1 = new DeletedMessagePK();
        DeletedMessagePK deletedMessagePK2 = new DeletedMessagePK();

        Optional<List<Message>> message1 = messageRepository.findAllBySenderAndReceiver(user_id, chosen_user_id);
        Optional<List<Message>> message2 = messageRepository.findAllBySenderAndReceiver(chosen_user_id, user_id);
        if (message1.isPresent()) {
            msgs1 = message1.get();
            for (Message message : msgs1) {
                deletedMessagePK1.setMessageId(message.getId());
                deletedMessagePK1.setUserId(user_id);
                deletedMessage1.setDeletedMessagePK(deletedMessagePK1);
                deletedMessageRepository.save(deletedMessage1);
                
            }
        }
        if (message2.isPresent()) {
            msgs2 = message2.get();
            for (Message message : msgs2) {
                 deletedMessagePK2.setMessageId(message.getId());
                deletedMessagePK2.setUserId(user_id);
                deletedMessage2.setDeletedMessagePK(deletedMessagePK2);
                deletedMessageRepository.save(deletedMessage2);
               
            }
        }


    }


//     @Override
//     public void deleteAllMessages(String user_id, String chosen_user_id) {
//     List<Message> messagesToDelete = new ArrayList<>();
//     DeletedMessage deletedMessage;
//     List<Long> messagesIds = new ArrayList<>();
    
//     Optional<List<Message>> messagesSentByUser = messageRepository.findAllBySenderAndReceiver(user_id, chosen_user_id);
//     Optional<List<Message>> messagesReceivedByUser = messageRepository.findAllBySenderAndReceiver(chosen_user_id, user_id);

//     if (messagesSentByUser.isPresent()) {
//         messagesToDelete.addAll(messagesSentByUser.get());
//     }
//     if (messagesReceivedByUser.isPresent()) {
//         messagesToDelete.addAll(messagesReceivedByUser.get());
//     }

//     deletedMessage = new DeletedMessage();
//     deletedMessage.setUserId(user_id);

//     for (Message message : messagesToDelete) {
//         DeletedMessage messageToDelete = new DeletedMessage();
//         messageToDelete.setMessageId(message.getId());
//         messageToDelete.setUserId(user_id);
//         deletedMessageRepository.save(messageToDelete);
//         messagesIds.add(message.getId());
//     }

  
// }


}
