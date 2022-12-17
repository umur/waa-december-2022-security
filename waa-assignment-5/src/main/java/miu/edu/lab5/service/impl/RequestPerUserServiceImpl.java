package miu.edu.lab5.service.impl;

import lombok.RequiredArgsConstructor;
import miu.edu.lab5.entity.RequestPerUser;
import miu.edu.lab5.repository.RequestPerUserRepo;
import miu.edu.lab5.repository.UserRepo;
import miu.edu.lab5.service.RequestPerUserService;
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