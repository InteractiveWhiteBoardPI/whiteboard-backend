package com.example.whiteboardbackend.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@DiscriminatorValue("file")
public class MessageFile extends Message{


    @Lob
    @Column(name = "content",columnDefinition="BLOB")
    private byte[] content;

    @Column(name = "file_name")
    private String fileName;

    @Column(name = "file_size")
    private Long fileSize;

}
