package com.example.springdata.Repository;


import com.example.springdata.Entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends CrudRepository<User,Integer> {
    User findByEmail(String email);
}
