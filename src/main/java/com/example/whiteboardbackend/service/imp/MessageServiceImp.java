package com.example.whiteboardbackend.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.whiteboardbackend.entity.Message;
import com.example.whiteboardbackend.repository.MessageRepository;
import com.example.whiteboardbackend.service.MessageService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MessageServiceImp implements MessageService {

    @Autowired
    MessageRepository messageRepository;

    @Override
    public Message saveMessage(Message message) {
       return messageRepository.save(message);
    }

    @Override
    public List<Message> getAll(){
        return (List<Message>) messageRepository.findAll();
    }
    
    @Override
    public void deleteMessage(Long id) {  
        messageRepository.deleteById(id);      
    }

    @Override
    public Optional<Message> findById(Long id) {
        return messageRepository.findById(id);
    }

    @Override
    public Optional<List<Message>> findAllBySenderOrReceiver(String sender, String receiver) {
        return messageRepository.findAllBySenderOrReceiver(sender, receiver);
    }


   
}
