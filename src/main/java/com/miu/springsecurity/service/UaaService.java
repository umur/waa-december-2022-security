package com.miu.springsecurity.service;

import com.miu.springsecurity.dto.UserDto;
import com.miu.springsecurity.model.LoginRequest;
import com.miu.springsecurity.model.LoginResponse;
import com.miu.springsecurity.model.RefreshTokenRequest;
import org.springframework.stereotype.Service;

@Service
public interface UaaService {
    LoginResponse signIn(LoginRequest loginRequest);
    LoginResponse refreshToken(RefreshTokenRequest refreshTokenRequest);
    LoginResponse singUp(UserDto userDto);
}
