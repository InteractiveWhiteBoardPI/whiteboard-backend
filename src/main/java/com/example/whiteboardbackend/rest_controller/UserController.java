package com.example.whiteboardbackend.rest_controller;

import com.example.whiteboardbackend.entity.Users;
import com.example.whiteboardbackend.exception.UserNotFoundException;
import com.example.whiteboardbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/get/{uid}")
    public ResponseEntity<Users> getUser(@PathVariable String uid) {
        try {
            return new ResponseEntity<>(userService.getUSer(uid), HttpStatus.OK);
        } catch (UserNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/save")
    public ResponseEntity<HttpStatus> saveUser(@RequestBody Users user) {
        userService.saveUser(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
