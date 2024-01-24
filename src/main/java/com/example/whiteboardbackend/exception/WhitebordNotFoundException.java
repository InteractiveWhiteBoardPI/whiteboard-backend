package com.example.whiteboardbackend.exception;

public class WhitebordNotFoundException extends RuntimeException{
    public WhitebordNotFoundException(String uid) {
        super(String.format("Whiteboard with uid : %s not found ", uid));
    }
}
