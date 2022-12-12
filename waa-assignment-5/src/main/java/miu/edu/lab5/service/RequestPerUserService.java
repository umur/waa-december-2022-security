package miu.edu.lab5.service;

import miu.edu.lab5.entity.RequestPerUser;

import java.util.List;

public interface RequestPerUserService {
    List<RequestPerUser> getAllByUser(String email);
    void save(RequestPerUser request);
    void deleteAllByUser(String email);
}