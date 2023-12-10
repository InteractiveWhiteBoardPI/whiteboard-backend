package com.example.whiteboardbackend.entity;


import com.example.whiteboardbackend.entity.entitypk.DeletedMessagePK;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "deleted_message")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DeletedMessage {

    @EmbeddedId
    DeletedMessagePK key;
}
