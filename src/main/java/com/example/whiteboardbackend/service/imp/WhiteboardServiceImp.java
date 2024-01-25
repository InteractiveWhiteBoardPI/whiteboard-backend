package com.example.whiteboardbackend.service.imp;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.whiteboardbackend.entity.LineData;
import com.example.whiteboardbackend.entity.Whiteboard;
import com.example.whiteboardbackend.exception.WhitebordNotFoundException;
import com.example.whiteboardbackend.repository.LineDataRepository;
import com.example.whiteboardbackend.repository.WhiteboardRepository;
import com.example.whiteboardbackend.service.WhiteboardService;

@Service
public class WhiteboardServiceImp  implements WhiteboardService{

    @Autowired
    WhiteboardRepository whiteboardRepository;

    @Autowired
    LineDataRepository lineDataRepository;


    @Override
    public List<Whiteboard> getWhiteboardsByUserUid(String uid) {
        return whiteboardRepository.findByOwnerUid(uid);
    }

    @Override
    public Whiteboard saveWhiteboard(Whiteboard whiteboard) {
        return whiteboardRepository.save(whiteboard);
    }

    @Override
    public Whiteboard getWhiteboard(UUID id) {
        Optional<Whiteboard> whiteboard = whiteboardRepository.findById(id);
        if(whiteboard.isPresent()) return whiteboard.get();
        throw new WhitebordNotFoundException(id.toString());
    }
    
    @Override
    public List<LineData> getSessionWhiteboardData(UUID session_uid) {
        return lineDataRepository.findBySessionUid(session_uid);
    }
}
