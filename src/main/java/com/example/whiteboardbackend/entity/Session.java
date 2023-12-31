package com.example.whiteboardbackend.entity;

import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "session")
public class Session {
    @Id
    @GeneratedValue
    private UUID uid;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "password", nullable = false)
    private String password;

    @OneToOne(optional = false, cascade = CascadeType.DETACH)
    @JoinColumn(name = "host_id", nullable = false)
    private User host;

    @OneToMany(mappedBy = "joinedSession",cascade = CascadeType.DETACH)
    private List<User> members;

    @JsonIgnore
    @OneToMany(mappedBy = "session", cascade = CascadeType.REMOVE)
    private List<LineData> whiteboardDatas;

    public void addMember(User user){
        this.members.add(user);
    }

}
