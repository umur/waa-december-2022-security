package miu.edu.springdata.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Data
@Entity
public class OffensiveUser {
    @Id
    private int id;

    private int wordCount;

    private LocalDateTime bannedUntil;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
