package com.example.whiteboardbackend.rest_controller;

import com.example.whiteboardbackend.entity.Users;
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
    public ResponseEntity<Users> getUser(@PathVariable String uid) {
        try {
            return new ResponseEntity<>(userService.getUSer(uid), HttpStatus.OK);
        } catch (UserNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/save")
    public ResponseEntity<HttpStatus> saveUser(@RequestBody Users user) {
        userService.saveUser(user);
        System.out.println(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/update-photo/{uid}/{username}")
    public ResponseEntity<HttpStatus> updateUserPhoto(@PathVariable String uid, @PathVariable String username, @RequestParam("image") MultipartFile image) throws IOException {
        try {
            Users user = userService.getUSer(uid);
            user.setUsername(username);
            user.setPhoto(image.getBytes());
            userService.saveUser(user); // Assuming you have a method to save the user
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            System.out.println("Error updating user photo: " + e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/update-photo/{uid}/{username}")
    public ResponseEntity<HttpStatus> deleteUserPhoto(@PathVariable String uid, @PathVariable String username) {
        Users user = userService.getUSer(uid);
        user.setUsername(username);
        user.setPhoto(null);
        System.out.println(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Users>> getUsers() {
        System.out.println(userService.getAllUsers());
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }
}
