package edu.miu.lab5.repository;

import edu.miu.lab5.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<User, Long> {


    User findByEmail(String email);

}
