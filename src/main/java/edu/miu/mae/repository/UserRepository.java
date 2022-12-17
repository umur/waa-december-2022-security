package edu.miu.mae.repository;

import edu.miu.mae.entity.User;
import edu.miu.mae.entity.UserOffensiveWords;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Set;

@Repository
@Transactional
public interface UserRepository extends CrudRepository<User,Integer> {
    public User findByEmail(String email);
    
}
