package edu.miu.codebase.service.impl;

import edu.miu.codebase.dto.UserDto;
import edu.miu.codebase.entity.User;
import edu.miu.codebase.repository.UserRepo;
import edu.miu.codebase.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;

    public final ModelMapper modelMapper;

    @Override
    public UserDto create(UserDto userDto) {
        return modelMapper.map(userRepo.save(modelMapper.map(userDto, User.class)), UserDto.class);
    }

    @Override
    public UserDto update(int userId, UserDto userDto) {
        User user = modelMapper.map(userDto, User.class);
        user = userRepo.save(user);
        return modelMapper.map(user, UserDto.class);
    }

    @Override
    public void delete(int userId) {
        User user = userRepo.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        userRepo.delete(user);
    }

    ///////////////////////// GET Methods /////////////////////////

    @Override
    public List<UserDto> getAll() {
        return userRepo.findAll().stream()
                .map(user -> modelMapper.map(user, UserDto.class))
                .toList();
    }

    @Override
    public UserDto getById(int userId) {
        return modelMapper.map(userRepo.findById(userId).orElseThrow(() -> new RuntimeException("User not found")), UserDto.class);
    }
}
