package edu.miu.springsecurity.repository;

import edu.miu.springsecurity.entity.RequestPerUser;
import edu.miu.springsecurity.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface RequestPerUserRepo extends CrudRepository<RequestPerUser, Integer> {
    Iterable<RequestPerUser> findAllByUserOrderByRequestTime(User user);
    void deleteAllByUser(User user);
}
