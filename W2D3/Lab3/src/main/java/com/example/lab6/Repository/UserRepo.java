package com.example.lab6.Repository;

import com.example.lab6.Entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepo extends CrudRepository<User,Integer> {
    Optional<org.springframework.security.core.userdetails.User> findByEmail(String username);
}
