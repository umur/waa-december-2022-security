package edu.miu.mae.service.impl;

import edu.miu.mae.StreamUtils;
import edu.miu.mae.dto.UserDto;
import edu.miu.mae.entity.User;
import edu.miu.mae.repository.UserRepository;
import edu.miu.mae.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void save(UserDto ad) {
        userRepository.save(modelMapper.map(ad, User.class));
    }

    @Override
    public UserDto getById(int id) {
        return modelMapper.map(userRepository.findById(id).get(),UserDto.class);
    }

    @Override
    public void update(UserDto ad, int id) {
        User paramDto = modelMapper.map(ad, User.class);

        if(paramDto.getId()!=id){
            userRepository.deleteById(id);
        }
        userRepository.save(paramDto);


    }

    @Override
    public void delete(int id) {
            userRepository.deleteById(id);
    }

    @Override
    public List<UserDto> getAll() {
       return  StreamUtils
                .asStream(userRepository.findAll())
                .map(x->modelMapper.map(x,UserDto.class))
               .collect(Collectors.toList());
    }
}
