package com.example.whiteboardbackend.rest_controller;

import com.example.whiteboardbackend.entity.User;
import com.example.whiteboardbackend.exception.UserNotFoundException;
import com.example.whiteboardbackend.service.UserService;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/get/{uid}")
    public ResponseEntity<User> getUser(@PathVariable String uid) {
        try {
            return new ResponseEntity<>(userService.getUSer(uid), HttpStatus.OK);
        } catch (UserNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/update-photo/{uid}/{username}")
    public ResponseEntity<User> updateEntity(@PathVariable String uid,@PathVariable String username ,@RequestPart("file") MultipartFile file) throws IOException {
        User result = userService.updateUser(uid,file.getBytes(),username);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/update-photo/{uid}/{username}")
    public ResponseEntity<User> updateEntity(@PathVariable String uid,@PathVariable String username) {
        byte[] image=new byte[2500];
        User result = userService.updateUser(uid,image,username);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/save")
    public ResponseEntity<HttpStatus> saveUser(@RequestBody User user) {
        userService.saveUser(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<User>> getUsers() {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }
}
