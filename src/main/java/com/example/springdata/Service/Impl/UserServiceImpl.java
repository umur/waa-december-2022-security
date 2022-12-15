package com.example.springdata.Service.Impl;



import com.example.springdata.Entity.User;
import com.example.springdata.Repository.UserRepo;
import com.example.springdata.Service.UserService;
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
    public void delete(Integer id) {
        userRepo.deleteById(id);
    }

    @Override
    public User getById(Integer id) {
        return userRepo.findById(id).get();
    }

    @Override
    public List<User> getAll() {
        var item = new ArrayList<User>();
        userRepo.findAll().forEach(item::add);
        return  item;
    }
}
