package com.example.whiteboardbackend.rest_controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.whiteboardbackend.entity.Session;
import com.example.whiteboardbackend.service.SessionService;

import java.util.UUID;

@RestController
@RequestMapping("/session")
@CrossOrigin(origins = "http://localhost:3000")
public class SessionController {

    @Autowired
    private SessionService sessionService;

    @PostMapping("/createSession")
    public ResponseEntity<Session> createSession(@RequestBody Session session) {
        Session savedSession = sessionService.saveSession(session);
        String sessionUrl = "http://localhost:3000/session/" + savedSession.getUid();
        System.out.println(sessionUrl);
        return new ResponseEntity<>(sessionService.saveSession(session), HttpStatus.CREATED);
    }

    @GetMapping("/join/{sessionId}")
    public ResponseEntity<Session> joinSession(@PathVariable UUID sessionId) {
        Session session = sessionService.getSessionById(sessionId);

        if (session != null) {
            return new ResponseEntity<>(session, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
