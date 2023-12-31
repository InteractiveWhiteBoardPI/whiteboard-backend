package com.example.whiteboardbackend.rest_controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.whiteboardbackend.entity.LineData;
import com.example.whiteboardbackend.entity.Whiteboard;
import com.example.whiteboardbackend.exception.WhitebordNotFoundException;
import com.example.whiteboardbackend.service.WhiteboardService;


@RestController
@RequestMapping("/whiteboard")
@CrossOrigin(origins = "http://localhost:3000")
public class WhiteboardController {

    @Autowired
    WhiteboardService whiteboardService;

    @GetMapping("/getAll/{id}")
    public ResponseEntity<List<Whiteboard>> getAll(@PathVariable String id) {
        return new ResponseEntity<>(whiteboardService.getWhiteboardsByUserUid(id),HttpStatus.OK);
    }
    
    @GetMapping("/get/{uid}")
    public ResponseEntity<Whiteboard> getWhiteboard(@PathVariable UUID uid) {
        try {
            return new ResponseEntity<>(whiteboardService.getWhiteboard(uid), HttpStatus.OK);
        } catch (WhitebordNotFoundException e) {
            return new ResponseEntity<>(null,HttpStatus.NO_CONTENT);
        }
        
    }
    
    @PostMapping("/save")
    public ResponseEntity<Whiteboard> save(@RequestBody Whiteboard whiteboard) {
        return new ResponseEntity<>(whiteboardService.saveWhiteboard(whiteboard),HttpStatus.OK);
    }

    @GetMapping("/session/{session_uid}")
    public ResponseEntity<List<LineData>> getSessionData(@PathVariable UUID session_uid) {
        return new ResponseEntity<>(whiteboardService.getSessionWhiteboardData(session_uid),HttpStatus.OK);
    }

}
