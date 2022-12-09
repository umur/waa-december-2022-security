package com.w1d3.springdata.repository;

import com.w1d3.springdata.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends CrudRepository<User,Integer> {
public User findByEmail(String username);


}
