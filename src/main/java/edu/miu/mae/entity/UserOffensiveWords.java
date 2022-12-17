package edu.miu.mae.entity;

import lombok.Data;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

@Entity
@Data
public class UserOffensiveWords {
    @EmbeddedId
    private UserOffensiveWordsId id;

    @ManyToOne
    @MapsId("userId")
    private User user;

    @ManyToOne
    @MapsId("OffensiveWordsId")
    private OffensiveWord offensiveWord;

    private long lastCreateTime;


}
