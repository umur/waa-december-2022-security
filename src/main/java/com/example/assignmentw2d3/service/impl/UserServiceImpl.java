package com.example.assignmentw2d3.service.impl;

import com.example.assignmentw2d3.entity.User;
import com.example.assignmentw2d3.repo.UserRepo;
import com.example.assignmentw2d3.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;

    @Override
    public List<User> getUsers() {
        return userRepo.findAll();
    }

    @Override
    public Optional<User> getUser(int userId) {
        return userRepo.findById(userId);
    }

    @Override
    public String deleteUser(int userId) {
        try {
            userRepo.deleteById(userId);
        } catch (Exception e) {
            throw e;
        }
        return "Successfully deleted the user!";
    }
}
