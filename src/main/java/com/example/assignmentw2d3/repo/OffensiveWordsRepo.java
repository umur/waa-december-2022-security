package com.example.assignmentw2d3.repo;

import com.example.assignmentw2d3.entity.OffensiveWord;
import com.example.assignmentw2d3.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface OffensiveWordsRepo extends JpaRepository<OffensiveWord, Integer> {
    public List<OffensiveWord> findAllByUserOrderByOccurrence(User user);
    public void deleteAllByUser_Id(int userId);
}
