package com.miu.springsecurity.service;

import com.miu.springsecurity.dto.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    List<UserDto> findAll();
    UserDto findById(int id);
    void save(UserDto userDto);
    void update(int id, UserDto userDto);
    void delete(int id);
}
