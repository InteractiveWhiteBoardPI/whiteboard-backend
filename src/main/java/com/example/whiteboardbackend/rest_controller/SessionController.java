package com.example.whiteboardbackend.rest_controller;

import com.example.whiteboardbackend.entity.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.whiteboardbackend.entity.Session;
import com.example.whiteboardbackend.service.SessionService;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/session")
@CrossOrigin(origins = "http://localhost:3000")
public class SessionController {

    @Autowired
    private SessionService sessionService;

    @PostMapping("/createSession")
    public ResponseEntity<Session> createSession(@RequestBody Session session) {
        return new ResponseEntity<>(sessionService.saveSession(session), HttpStatus.CREATED);

    }

    @GetMapping("/get/{sessionId}")
    public ResponseEntity<Session> getSession(@PathVariable UUID sessionId) {
        return new ResponseEntity<>(sessionService.getSession(sessionId), HttpStatus.OK);
    }

    @GetMapping("/get/{sessionName}/{sessionPassword}")
    public ResponseEntity<Session> getSession(
            @PathVariable String sessionName,
            @PathVariable String sessionPassword
    ) {
        return new ResponseEntity<>(sessionService.getSession(sessionName, sessionPassword), HttpStatus.OK);
    }

    @PostMapping("/join/{sessionId}")
    public ResponseEntity<HttpStatus> addMember(
            @RequestBody User member,
            @PathVariable UUID sessionId
    ) {
        sessionService.addMember(member, sessionId);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/get-members/{sessionId}")
    public ResponseEntity<List<User>> getMembers(@PathVariable UUID sessionId) {
        return new ResponseEntity<>(sessionService.getMembers(sessionId),HttpStatus.OK);
    }

    @GetMapping("/is-session-exist/{sessionId}")
    public ResponseEntity<Boolean> isSessionExist(@PathVariable UUID sessionId) {
        return new ResponseEntity<>(sessionService.isSessionExist(sessionId),HttpStatus.OK);
    }

    @GetMapping("/name/{sessionId}")
    public ResponseEntity<String> getSessionName(@PathVariable UUID sessionId) {
        return new ResponseEntity<>(sessionService.getSessionName(sessionId),HttpStatus.OK);
    }

 
    



}
