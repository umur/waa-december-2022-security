package miu.edu.springsecuritylab6.repository;


import miu.edu.springsecuritylab6.entity.CountUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountUserRepository extends CrudRepository<CountUser, Long> {
}
