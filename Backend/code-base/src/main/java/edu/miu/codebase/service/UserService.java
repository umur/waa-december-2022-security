package edu.miu.codebase.service;

import edu.miu.codebase.dto.UserDto;
import edu.miu.codebase.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    UserDto create(UserDto userDto);

    UserDto update(int userId, UserDto userDto);

    void delete(int userId);

    ///////////////////////// GET Methods /////////////////////////

    UserDto getById(int userId);

    List<UserDto> getAll();

}
