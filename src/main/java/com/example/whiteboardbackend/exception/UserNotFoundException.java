package com.example.whiteboardbackend.exception;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(String uid) {
        super("The username '" + uid + "' does not exist!");
    }
}
