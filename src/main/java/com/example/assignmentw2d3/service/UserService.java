package com.example.assignmentw2d3.service;

import com.example.assignmentw2d3.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    public List<User> getUsers();
    public Optional<User> getUser(int userId);
    public String deleteUser(int userId);
}
