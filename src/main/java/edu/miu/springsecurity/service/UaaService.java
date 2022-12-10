package edu.miu.springsecurity.service;

import edu.miu.springsecurity.dto.UserDto;
import edu.miu.springsecurity.model.LoginRequest;
import edu.miu.springsecurity.model.LoginResponse;

public interface UaaService {
    LoginResponse signIn(LoginRequest loginRequest);
    void signUp(UserDto userDto);
}
