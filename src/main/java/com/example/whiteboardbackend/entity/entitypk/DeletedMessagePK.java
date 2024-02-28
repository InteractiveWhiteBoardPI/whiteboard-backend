package com.example.whiteboardbackend.entity.entitypk;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Embeddable
public class DeletedMessagePK implements Serializable {
    private Long messageId;
    private String userId;
}