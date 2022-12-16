package com.directional.SpringDataAssignment.SpringDataAssignment.Service;

import com.directional.SpringDataAssignment.SpringDataAssignment.Entity.BiDirectional.User;

import java.util.List;

public interface UserService {


    public void saveOrUpdate(User user);
    public void delete(Long id);
    public User getById(Long id);
    public List<User> getAll();
}
