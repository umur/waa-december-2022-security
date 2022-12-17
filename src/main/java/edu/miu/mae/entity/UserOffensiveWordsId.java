package edu.miu.mae.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@RequiredArgsConstructor
public class UserOffensiveWordsId implements Serializable {

    private int userId;
    private int OffensiveWordsId;


    public UserOffensiveWordsId(int OffensiveWordsId, int userId) {
        this.OffensiveWordsId = OffensiveWordsId;
        this.userId = userId;
    }
}
