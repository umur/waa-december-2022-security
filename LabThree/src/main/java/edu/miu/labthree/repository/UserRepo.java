package edu.miu.labthree.repository;

import edu.miu.labthree.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserRepo extends CrudRepository<User,Integer > {

    User findByEmail(String email);
}
