package com.example.whiteboardbackend.service;


import com.example.whiteboardbackend.exception.WhitebordNotFoundException;
import com.example.whiteboardbackend.entity.Whiteboard;
import java.util.List;
import java.util.UUID;

public interface WhiteboardService {
    public List<Whiteboard> getWhiteboardsByUserUid(String uid);
    public Whiteboard getWhiteboard(UUID id) throws WhitebordNotFoundException;
    public Whiteboard saveWhiteboard(Whiteboard whiteboard);
}
