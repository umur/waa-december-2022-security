package edu.miu.springsecurity.service;

import edu.miu.springsecurity.entity.RequestPerUser;

import java.util.List;

public interface RequestPerUserService {
    List<RequestPerUser> getAllByUser(String email);
    void save(RequestPerUser request);
    void deleteAllByUser(String email);
}

