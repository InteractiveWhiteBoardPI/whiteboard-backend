package com.example.whiteboardbackend.rest_controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.whiteboardbackend.entity.DeletedMessagePK;
import com.example.whiteboardbackend.service.DeletedMessageService;
import com.example.whiteboardbackend.service.MessageService;

@Controller
@CrossOrigin(origins = "http://localhost:3000")
public class DeletedMessageController {


    @Autowired
    DeletedMessageService deletedMessageService;

    @Autowired
    MessageService messageService;


    @PostMapping("/message/delete")
    public ResponseEntity<HttpStatus> deleteMsg(@RequestBody DeletedMessagePK msg){
        deletedMessageService.deleteMsg(msg);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/message/delete/all/{user_id}/{chosen_user_id}")
    public ResponseEntity<HttpStatus> deleteAllMsg(@PathVariable String user_id, @PathVariable String chosen_user_id){
        deletedMessageService.deleteAllMessages(user_id, chosen_user_id);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    
}
