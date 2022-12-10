package edu.miu.springsecurity.service.impl;

import edu.miu.springsecurity.entity.RequestPerUser;
import edu.miu.springsecurity.repository.RequestPerUserRepo;
import edu.miu.springsecurity.repository.UserRepo;
import edu.miu.springsecurity.service.RequestPerUserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RequestPerUserServiceImpl implements RequestPerUserService {

    private final RequestPerUserRepo requestPerUserRepo;
    private final UserRepo userRepo;
    private final ModelMapper modelMapper;

    @Override
    public List<RequestPerUser> getAllByUser(String email) {
        var user = userRepo.findByEmail(email);
        return convertIteratorToList(requestPerUserRepo.findAllByUserOrderByRequestTime(user));
    }

    @Override
    public void save(RequestPerUser request) {
        requestPerUserRepo.save(request);
    }

    @Override
    public void deleteAllByUser(String email) {
        var user = userRepo.findByEmail(email);
        requestPerUserRepo.deleteAllByUser(user);
    }

    private List<RequestPerUser> convertIteratorToList(Iterable<RequestPerUser> iterable){
        List<RequestPerUser> list = new ArrayList<>();
        iterable.forEach(e -> list.add(modelMapper.map(e, RequestPerUser.class)));
        return list;
    }
}
