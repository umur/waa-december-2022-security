package miu.edu.lab5.service;


import miu.edu.lab5.entity.User;

import java.util.List;

public interface UserService {

    User getById(int id);
    List<User> getAll();
    void save( User user);
    void update (int id, User user);
    void delete(int id);

}
