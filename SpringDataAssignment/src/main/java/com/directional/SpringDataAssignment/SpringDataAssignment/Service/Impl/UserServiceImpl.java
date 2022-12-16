package com.directional.SpringDataAssignment.SpringDataAssignment.Service.Impl;


import com.directional.SpringDataAssignment.SpringDataAssignment.Entity.BiDirectional.User;
import com.directional.SpringDataAssignment.SpringDataAssignment.Repository.UserRepo;
import com.directional.SpringDataAssignment.SpringDataAssignment.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    public final UserRepo userRepo;


    @Override
    public void saveOrUpdate(User user) {
        userRepo.save(user);
    }

    @Override
    public void delete(Long id) {
        userRepo.deleteById(id);
    }

    @Override
    public User getById(Long id) {
        return userRepo.findById(id).get();
    }

    @Override
    public List<User> getAll() {
        var item = new ArrayList<User>();
        userRepo.findAll().forEach(item::add);
        return  item;
    }
}
