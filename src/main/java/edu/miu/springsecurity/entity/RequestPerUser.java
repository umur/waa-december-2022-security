package edu.miu.springsecurity.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class RequestPerUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private LocalDateTime requestTime;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
