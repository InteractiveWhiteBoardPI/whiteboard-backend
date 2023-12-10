package com.example.whiteboardbackend.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "users")
@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
public class User {
    
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

    @JsonIgnore()
    @OneToMany(mappedBy = "owner", cascade = CascadeType.REMOVE)
    private List<Whiteboard> whiteboards ;

    @JsonIgnore()
    @ManyToOne()
    @JoinColumn(name = "joined_session")
    private Session joinedSession;

    @Override
    public String toString() {
        return "Users{" +
                "uid='" + uid + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                '}';
    }


}
