package miu.edu.springdata.service.impl;

import lombok.RequiredArgsConstructor;
import miu.edu.springdata.annotation.ExecutionTime;
import miu.edu.springdata.dto.ReviewDto;
import miu.edu.springdata.dto.UserDto;
import miu.edu.springdata.entity.Review;
import miu.edu.springdata.entity.User;
import miu.edu.springdata.repository.UserRepo;
import miu.edu.springdata.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;
    private final ModelMapper mapper;

    @Override
    @ExecutionTime
    public void save(User address){
        userRepo.save(address);
    }

    @Override
    @PreAuthorize("hasRole('ROLE_GOLD')")
    public List<UserDto> findAll() {
        return getDtoList ((List<User>) userRepo.findAll());
    }

    @Override
    public UserDto findByEmail(String email) {
        return getDto(userRepo.findByEmail(email));
    }

    @Override
    public UserDto findById(int id) {
        return getDto(userRepo.findById(id).get());
    }

    @Override
    public void deleteById(int id) {
        userRepo.deleteById(id);
    }


    private List<UserDto> getDtoList(List<User> users){
        return users.stream().map(p->{
            return getDto(p);
        }).toList();
    }
    private UserDto getDto(User user){
        return mapper.map(user, UserDto.class);
    }
}