package miu.edu.springdata.service;

import miu.edu.springdata.dto.UserDto;
import miu.edu.springdata.entity.User;

import java.util.List;

public interface UserService {
    void save(User user);
    List<UserDto> findAll();
    UserDto findById(int id);
    void deleteById(int id);

    public UserDto findByEmail(String email);
}
