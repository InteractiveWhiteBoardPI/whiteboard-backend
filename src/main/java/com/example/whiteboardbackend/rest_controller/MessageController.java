package com.example.whiteboardbackend.rest_controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.whiteboardbackend.entity.DeletedMessage;
import com.example.whiteboardbackend.entity.Message;
import com.example.whiteboardbackend.entity.MessageFile;
import com.example.whiteboardbackend.entity.MessageText;
import com.example.whiteboardbackend.service.MessageService;

@Controller
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/message")
public class MessageController {

    @Autowired
    MessageService messageService;
     
    @GetMapping("/all/{id}")
    public ResponseEntity<List<Message>> getAllMessages(@PathVariable String id){
        return new ResponseEntity<>(messageService.getUserMessages(id),HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Message> saveMessageText(@RequestBody MessageText message){
        return new ResponseEntity<>(messageService.saveMessage(message),HttpStatus.CREATED);
    }

    @PostMapping("/save/file")
    public ResponseEntity<Message> saveMessageFile(@RequestBody MessageFile message) {
        return new ResponseEntity<>(messageService.saveMessage(message),HttpStatus.CREATED);
    }
  

    @PostMapping("/delete")
    public ResponseEntity<HttpStatus> deleteMsg(@RequestBody DeletedMessage message){
        messageService.deleteMsg(message);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/delete/all/{user_id}/{chosen_user_id}")
    public ResponseEntity<HttpStatus> deleteAllMsg(
            @PathVariable String user_id,
            @PathVariable String chosen_user_id
    ){
        messageService.deleteAllMessages(user_id, chosen_user_id);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/session/{receiver}")
    public ResponseEntity<List<Message>> getSessionMessages(@PathVariable String receiver){
        return new ResponseEntity<>(messageService.getSessionMessages(receiver),HttpStatus.OK);
    }

}
