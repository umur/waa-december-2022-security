package com.example.springdata.Service;

import com.example.springdata.model.*;


public interface UaaService {
    LoginResponse login(LoginRequest loginRequest);
    LoginResponse refreshToken(RefreshTokenRequest refreshTokenRequest);

    SignUpResponse userSignUpRequest(SignUpRequest signUpRequest);
}
