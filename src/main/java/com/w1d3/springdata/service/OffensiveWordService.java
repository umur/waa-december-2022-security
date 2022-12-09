package com.w1d3.springdata.service;

import com.w1d3.springdata.entity.OffensiveUser;

public interface OffensiveWordService {
    OffensiveUser findByUserId(int userId);

    void saveOffensiveUser(OffensiveUser offensiveUser);

    boolean scanOffensiveWord(Object[] args);

    boolean checkIfBanned();

}
