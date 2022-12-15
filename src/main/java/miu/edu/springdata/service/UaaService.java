package miu.edu.springdata.service;

import miu.edu.springdata.entity.User;
import miu.edu.springdata.model.LoginRequest;
import miu.edu.springdata.model.LoginResponse;

public interface UaaService {
    LoginResponse login(LoginRequest loginRequest);
    void register(User user);
}
