package com.example.assignmentw2d3.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class OffensiveWord {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private LocalDateTime occurrence;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JsonBackReference
    private User user;
}
