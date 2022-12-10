package edu.miu.labthree.service.impl;

import edu.miu.labthree.dto.UserDto;
import edu.miu.labthree.entity.User;
import edu.miu.labthree.repository.UserRepo;
import edu.miu.labthree.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {

    private final ModelMapper modelMapper;
    private final UserRepo userRepo;

    public UserServiceImpl(ModelMapper modelMapper, UserRepo userRepo) {
        this.modelMapper = modelMapper;
        this.userRepo = userRepo;
    }

    @Override
    public void save(UserDto userDto) {
        User user = modelMapper.map(userRepo, User.class);
        userRepo.save(user);
    }

    @Override
    public void delete(int id) {
        userRepo.deleteById(id);
    }

    @Override
    public void update(int id, UserDto userDto) {
        User user = modelMapper.map(userDto, User.class);

        User oldUser = userRepo.findById(id).get();
        userRepo.delete(oldUser);
        user.setId(id);
        userRepo.save(user);
    }

    @Override
    public List<UserDto> getAll() {
        List<User> users = (List<User>) userRepo.findAll();
        return users.stream().map(user -> modelMapper.map(user, UserDto.class)).toList();
    }

    @Override
    public UserDto getById(int id){

        User user = userRepo.findById(id).get();
        return modelMapper.map(user,UserDto.class);
    }
}
