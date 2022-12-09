package miu.edu.springdata.service;

import miu.edu.springdata.entity.OffensiveUser;
import org.springframework.stereotype.Repository;

public interface OffensiveUserService {
    OffensiveUser findByUserId(int userId);

    void saveOffensiveUser(OffensiveUser offensiveUser);

    boolean scanOffensiveWord(Object[] args);

    boolean checkIfBanned();
}
