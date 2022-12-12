package com.example.lab6.Service;

import com.example.lab6.Entity.User;

import java.util.List;

public interface Userservice {
    public void saveOrUpdate(User user);
    public List<User> getAll();
    public void delete(int id);
    public User getById(int id);

}
