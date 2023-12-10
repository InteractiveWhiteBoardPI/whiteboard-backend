package com.example.whiteboardbackend.rest_controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.whiteboardbackend.entity.DeletedMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.example.whiteboardbackend.entity.Message;
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
    public ResponseEntity<Message> saveMessage(@RequestBody Message message){
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

    

}
