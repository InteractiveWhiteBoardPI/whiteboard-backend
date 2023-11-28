package com.example.whiteboardbackend.entity;

import lombok.*;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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

    @NonNull
    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @NonNull
    @Column(name = "email", nullable = false)
    private String email;

    @Override
    public String toString() {
        return "Users{" +
                "uid='" + uid + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
