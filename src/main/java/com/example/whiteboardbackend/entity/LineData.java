package com.example.whiteboardbackend.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "line_data")
public class LineData implements Serializable {

    @Id
    private String id;

    private Position lineOffset;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "line_positions", joinColumns = @JoinColumn(name = "line_id"))
    private List<Position> positions;
    private String color;
    private String bkColor;
    private double width;
    private boolean bucket;

    @ManyToOne()
    @JoinColumn(name = "session_uid", nullable = false)
    private Session session;

    @Override
    public String toString() {
        return "LineData{" +
                "id='" + id + '\'' +
                "positions=" + positions.size() +
                ", color='" + color + '\'' +
                ", bkColor='" + bkColor + '\'' +
                ", bucket=" + bucket +
                '}';
    }
}