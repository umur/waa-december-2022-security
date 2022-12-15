package miu.edu.springsecuritylab6.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Data
@NoArgsConstructor
public class CountUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String content;
    private String username;
    private Instant createdAt;

    public CountUser(String content, String username) {
        this.content = content;
        this.username = username;
        this.createdAt = Instant.now();
    }
}
