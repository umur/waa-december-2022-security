package com.w1d3.springdata.service;

import com.w1d3.springdata.entity.model.LoginRequest;
import com.w1d3.springdata.entity.model.LoginResponse;
import com.w1d3.springdata.entity.model.RefreshTokenRequest;

public interface UaaService {
    LoginResponse login(LoginRequest loginRequest);
    LoginResponse refreshToken(RefreshTokenRequest refreshTokenRequest);
}
