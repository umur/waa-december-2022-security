package edu.miu.labthree.service;


import edu.miu.labthree.dto.UserDto;

import java.util.List;

public interface UserService {
    void save(UserDto userDto);
    void delete (int id);
    void update (int id, UserDto userDto);
    List<UserDto> getAll();
    UserDto getById(int id);
}
