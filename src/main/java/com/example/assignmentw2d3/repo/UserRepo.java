package com.example.assignmentw2d3.repo;

import com.example.assignmentw2d3.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {
     public User findByEmail(String email);
}
