package com.example.whiteboardbackend.rest_controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.whiteboardbackend.entity.Session;

import com.example.whiteboardbackend.service.SessionService;
import com.example.whiteboardbackend.service.UserService;
import com.example.whiteboardbackend.entity.Users;

@RestController
@RequestMapping("/session")
@CrossOrigin(origins = "http://localhost:3000")
public class SessionController {

    @Autowired
    private SessionService sessionService;
    @Autowired
    private UserService userService;

    @PostMapping("/createSession")
    public ResponseEntity<Session> createSession(@PathVariable Session session) {
        return new ResponseEntity<>(sessionService.saveSession(session), HttpStatus.CREATED);

    }
   @PostMapping("/app/joinSession/{sessionId}")
    public ResponseEntity<String> joinSession(@PathVariable String sessionId, @RequestParam String name) {
 
    Users user = this.userService.getUserByUsername(name);
    sessionService.joinSession(sessionId, user);
    System.out.println("joined");
    return ResponseEntity.ok("Joined session successfully");
}
}
