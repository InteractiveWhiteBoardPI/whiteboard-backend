package com.example.whiteboardbackend.rest_controller;

import  com.example.whiteboardbackend.entity.User;
import com.example.whiteboardbackend.exception.UserNotFoundException;
import com.example.whiteboardbackend.service.UserService;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

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

    @GetMapping("/peer/{peerId}")
    public ResponseEntity<User> getUserByPeerId(@PathVariable String peerId) {
        try {
            return new ResponseEntity<>(userService.getUserByPeerId(peerId), HttpStatus.OK);
        } catch (UserNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update-peer/{uid}/{peerId}")
    public ResponseEntity<User> updateUserPeerId(@PathVariable String uid, @PathVariable String peerId) {
        try {
            User user = userService.getUSer(uid);
            user.setPeerId(peerId);
            return new ResponseEntity<>(userService.saveUser(user),HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/save")
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        try {
            return new ResponseEntity<>(userService.saveUser(user),HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/username/{uid}")
    public ResponseEntity<Map<String,String>> getUserName(@PathVariable String uid) {
        try {
            Map<String, String> map = new HashMap<>();
            map.put("username", userService.getUSer(uid).getUsername());
            return new ResponseEntity<>(map, HttpStatus.OK);
        } catch (UserNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/{userId}/leave/{sessionId}")
    public ResponseEntity<HttpStatus> postMethodName(@PathVariable String userId, @PathVariable UUID sessionId) {
        userService.removeMemberFromSession(userId, sessionId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/update-photo/{uid}/{username}")
    public ResponseEntity<User> updateUserPhoto(
            @PathVariable String uid,
            @PathVariable String username,
            @RequestBody MultipartFile image) throws IOException {
        try {
            User user = userService.getUSer(uid);
            user.setUsername(username);
            if(image!= null) {
                user.setImageByte(image.getBytes());
            }
            return new ResponseEntity<>(userService.saveUser(user),HttpStatus.OK);
        } catch (Exception e) {
            System.out.println("Error updating user photo: " + e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/update-photo/{uid}/{username}")
    public ResponseEntity<User> deleteUserPhoto(@PathVariable String uid, @PathVariable String username) {
        User user = userService.getUSer(uid);
        user.setUsername(username);
        user.setImageByte(null);
        User usr = userService.saveUser(user);
        return new ResponseEntity<>(usr,HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<User>> getUsers() {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }
}
