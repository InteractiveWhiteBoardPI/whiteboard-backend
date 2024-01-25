package com.example.whiteboardbackend.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserMedia {
    private boolean audio;
    private boolean video;
    private boolean mute;
    private String userId;
}
