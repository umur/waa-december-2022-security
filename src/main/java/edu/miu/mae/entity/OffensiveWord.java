package edu.miu.mae.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name="Offensivewords")
public class OffensiveWord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String word;

    @OneToMany(mappedBy = "offensiveWord")
    private Set<UserOffensiveWords>
            userOffensiveWords = new HashSet<>();


}
