package edu.miu.mae.repository;

import edu.miu.mae.entity.UserOffensiveWords;
import edu.miu.mae.entity.UserOffensiveWordsId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserOffensiveWordsRepository extends CrudRepository<UserOffensiveWords, UserOffensiveWordsId> {
//    public List<UserOffensiveWords> findByContributors_id(String id);
//
//    findByUserId

//    @Query("select distinct ad_id from EntityClass where userId = :userId and (/*here the conditions*/)")
    public List<UserOffensiveWords> findUserOffensiveWordsByUserIdAndLastCreateTimeLessThan(int userId,long time);
    public List<UserOffensiveWords> findUserOffensiveWordsByOffensiveWord_Id(String wordId);
}
