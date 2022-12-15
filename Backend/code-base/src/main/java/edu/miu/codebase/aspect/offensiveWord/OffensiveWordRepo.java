package edu.miu.codebase.aspect.offensiveWord;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OffensiveWordRepo extends JpaRepository<OffensiveWord, Integer> {
    OffensiveWord findByUser_Email(String email);
}
