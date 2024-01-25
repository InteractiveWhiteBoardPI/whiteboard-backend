package com.example.whiteboardbackend.repository;


import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.whiteboardbackend.entity.LineData;

public interface LineDataRepository extends JpaRepository<LineData, String>{
    List<LineData> findBySessionUid(UUID session_uid);
} 
