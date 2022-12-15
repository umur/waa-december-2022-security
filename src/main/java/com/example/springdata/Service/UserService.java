package com.example.springdata.Service;



import com.example.springdata.Entity.User;

import java.util.List;

public interface UserService {
    public void saveOrUpdate(User user);
    public void delete(Integer id);
    public User getById(Integer id);
    public List<User> getAll();
}
