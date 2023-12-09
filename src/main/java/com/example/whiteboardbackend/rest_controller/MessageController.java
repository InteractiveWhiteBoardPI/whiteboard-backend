package com.example.whiteboardbackend.rest_controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.whiteboardbackend.entity.Message;
import com.example.whiteboardbackend.service.DeletedMessageService;
import com.example.whiteboardbackend.service.MessageService;

@Controller
@CrossOrigin(origins = "http://localhost:3000")
public class MessageController {

    @Autowired
    MessageService messageService;

    @Autowired
    DeletedMessageService deletedMessageService;

     
    @GetMapping("/message/all/{id}")
    public ResponseEntity<List<Message>> getAllMessages(@PathVariable String id){
        Optional<List<Message>> messages = messageService.findAllBySenderOrReceiver(id, id);
        List<Message> filteredMessages = new ArrayList<>();
        if(messages.isPresent()){
            List<Message> userMessages = messages.get();
            for(Message message: userMessages){
                if(!deletedMessageService.findByMessageIdAndUserId(message.getId(),id).isPresent()){
                    filteredMessages.add(message);
                }
            }
        }
        return new ResponseEntity<>(filteredMessages,HttpStatus.OK);
    }

    @DeleteMapping("/message/{id}")
     public ResponseEntity<HttpStatus> deleteMessage(@PathVariable Long id) {
        messageService.deleteMessage(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @PostMapping("/message/save")
    public ResponseEntity<Message> saveMessage(@RequestBody Message message){
        return new ResponseEntity<>(messageService.saveMessage(message),HttpStatus.CREATED);
    }

    

}
