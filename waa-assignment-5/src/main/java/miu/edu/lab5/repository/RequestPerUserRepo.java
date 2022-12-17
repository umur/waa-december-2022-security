package miu.edu.lab5.repository;


import miu.edu.lab5.entity.RequestPerUser;
import miu.edu.lab5.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface RequestPerUserRepo extends CrudRepository<RequestPerUser, Integer> {
    Iterable<RequestPerUser> findAllByUserOrderByRequestTime(User user);
    void deleteAllByUser(User user);
}