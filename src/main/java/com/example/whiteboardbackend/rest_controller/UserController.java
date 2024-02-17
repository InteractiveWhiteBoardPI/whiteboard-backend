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

    @GetMapping("/exist/{uid}")
    public ResponseEntity<Boolean> isExist(@PathVariable String uid) {
        boolean exists = userService.userExist(uid);
        System.out.println(exists);
        return new ResponseEntity<>(exists, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<HttpStatus> saveUser(@RequestBody User user) {
        userService.saveUser(user);
        System.out.println(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/update-photo/{uid}/{username}")
    public ResponseEntity<HttpStatus> updateUserPhoto(@PathVariable String uid, @PathVariable String username, @RequestParam("image") MultipartFile image) throws IOException {
        try {
            User user = userService.getUSer(uid);
            user.setUsername(username);
            user.setImageByte(image.getBytes());
            userService.saveUser(user); // Assuming you have a method to save the user
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            System.out.println("Error updating user photo: " + e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/update-photo/{uid}/{username}")
    public ResponseEntity<HttpStatus> deleteUserPhoto(@PathVariable String uid, @PathVariable String username) {
        User user = userService.getUSer(uid);
        user.setUsername(username);
        user.setImageByte(new byte[0]);
        userService.saveUser(user);
        user.setImageByte(null);
        userService.saveUser(user);
        System.out.println(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<User>> getUsers() {
        System.out.println(userService.getAllUsers());
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }
}
