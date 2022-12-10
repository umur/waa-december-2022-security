package com.miu.springsecurity.service.impl;

import com.miu.springsecurity.dto.UserDto;
import com.miu.springsecurity.entity.User;
import com.miu.springsecurity.repository.UserRepo;
import com.miu.springsecurity.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@Service
@RequiredArgsConstructor
//@PreAuthorize("hasRole('ROLE_ADMIN')")
public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;
    private final ModelMapper modelMapper;

    @Override
    public List<UserDto> findAll() {
        return userRepo.findAll().stream().map(a -> modelMapper.map(a, UserDto.class)).toList();
    }

    @Override
    public UserDto findById(int id) {
        return userRepo.findById(id).map(a -> modelMapper.map(a, UserDto.class)).get();
    }

    @Override
    public void save(UserDto userDto) {
        User user = modelMapper.map(userDto, User.class);
        userRepo.save(user);
    }

    @Override
    public void update(int id, UserDto userDto) {
        userRepo.findById(id).orElseThrow(() -> new RuntimeException("User not found."));
        User user = modelMapper.map(userDto, User.class);
        userRepo.save(user);
    }

    @Override
    public void delete(int id) {
        User user = userRepo.findById(id).orElseThrow(() -> new RuntimeException("User not found."));
        userRepo.delete(user);
    }
}
