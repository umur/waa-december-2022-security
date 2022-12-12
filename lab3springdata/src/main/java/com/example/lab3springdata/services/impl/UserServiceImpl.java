package com.example.lab3springdata.services.impl;

import com.example.lab3springdata.dto.userDto.UserBasicDto;
import com.example.lab3springdata.entity.User;
import com.example.lab3springdata.repository.UserRepo;
import com.example.lab3springdata.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;
    private final ModelMapper modelMapper;

    public UserServiceImpl(UserRepo userRepo, ModelMapper modelMapper) {
        this.userRepo = userRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public UserBasicDto getById(int id) {
        User user= userRepo.findById(id).get();
        return modelMapper.map(user,UserBasicDto.class);
    }

    @Override
    public List<UserBasicDto> getAll() {
        List<User> userList = (List<User>) userRepo.findAll();
        return userList
                .stream()
                .map(
                        user->modelMapper
                                .map(user,UserBasicDto.class))
                .toList();
    }

    @Override
    public void save(UserBasicDto userDto) {
        User user = modelMapper.map(userDto,User.class);
        userRepo.save(user);
    }

    @Override
    public void update(int id, UserBasicDto userDto) {

        User user = modelMapper.map(userDto,User.class);

        User oldUser = userRepo.findById(id).get();
        userRepo.delete(oldUser);
        user.setId(id);
        userRepo.save(user);
    }

    @Override
    public void delete(int id) {
        userRepo.deleteById(id);
    }
}
