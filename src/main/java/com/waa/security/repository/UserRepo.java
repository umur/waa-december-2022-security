package com.waa.security.repository;

import com.waa.security.entity.Product;
import com.waa.security.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<User, Long> {


    User findByEmail(String email);

}
