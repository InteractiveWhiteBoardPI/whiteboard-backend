package com.example.whiteboardbackend.entity;

import lombok.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "users")
@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
public class Users {
    
    @Id
    @Column(name = "uid")
    private String uid;

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @NonNull
    @Column(name = "email", nullable = false)
    private String email;
    
    @JsonIgnore()
    @OneToOne(mappedBy = "host", cascade = CascadeType.DETACH)
    private Session session;
    @Column(columnDefinition = "blob")
    private byte[] photo;

    @Override
    public String toString() {
        return "Users{" +
                "uid='" + uid + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", session=" + session +
                ", photo=" + photo +
                '}';
    }
}
