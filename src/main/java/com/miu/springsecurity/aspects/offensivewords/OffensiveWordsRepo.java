package com.miu.springsecurity.aspects.offensivewords;

import com.miu.springsecurity.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OffensiveWordsRepo extends JpaRepository<OffensiveWords, Integer> {
    OffensiveWords findByUser(User user);
}
