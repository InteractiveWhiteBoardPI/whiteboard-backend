package com.example.whiteboardbackend.entity;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;


@Entity
@Table(name = "whiteboard")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Whiteboard {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "data", columnDefinition = "BLOB")
    private byte[] data;

    @Column(name = "display_image", columnDefinition = "TEXT")
    private String displayImage;

    @Column(name= "name", nullable = false)
    private String name;

    @Column(name= "last_modified", nullable = false)
    private LocalDate lastModified;


    @ManyToOne(optional = false)
    @JoinColumn(name = "user_uid", referencedColumnName = "uid")
    private User owner;

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", data='" + getData() + "'" +
            ", name='" + getName() + "'" +
            ", lastModified='" + getLastModified() + "'" +
            ", owner='" + getOwner() + "'" +
            "}";
    }
}
