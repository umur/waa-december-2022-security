package com.miu.springsecurity.aspects.offensivewords;

import com.miu.springsecurity.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OffensiveWords {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int consecutiveCount;
    private LocalDateTime detectedDate;
    @OneToOne
    private User user;
}
