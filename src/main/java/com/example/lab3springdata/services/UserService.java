package com.example.lab3springdata.services;

import com.example.lab3springdata.dto.userDto.UserBasicDto;
import com.example.lab3springdata.entity.User;

import java.util.List;

public interface UserService {
    UserBasicDto getById(int id);
    List<UserBasicDto>  getAll();
    void save(UserBasicDto user);
    void update(int id, UserBasicDto user);
    void delete(int id);

}
