package miu.edu.lab5.repository;

import miu.edu.lab5.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends CrudRepository<User, Integer> {

    User findByEmail(String email);
}
