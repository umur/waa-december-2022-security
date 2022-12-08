package com.w1d3.springdata.service;

import com.w1d3.springdata.dto.UserDto;
import com.w1d3.springdata.entity.User;

import java.util.List;

public interface UserService {
    List<UserDto> findAll();
    void save(User user);
    UserDto findById(int id);
    void deleteById(int id);

}
