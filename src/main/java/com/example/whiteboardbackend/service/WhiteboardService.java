package com.example.whiteboardbackend.service;


import com.example.whiteboardbackend.exception.WhitebordNotFoundException;
import com.example.whiteboardbackend.entity.LineData;
import com.example.whiteboardbackend.entity.Whiteboard;
import java.util.List;
import java.util.UUID;

public interface WhiteboardService {
    List<Whiteboard> getWhiteboardsByUserUid(String uid);
    Whiteboard getWhiteboard(UUID id) throws WhitebordNotFoundException;
    Whiteboard saveWhiteboard(Whiteboard whiteboard);
    List<LineData> getSessionWhiteboardData(UUID session_uid);
}
