package edu.miu.springsecurity1.service;

import edu.miu.springsecurity1.Dto.*;
import edu.miu.springsecurity1.model.LoginRequest;
import edu.miu.springsecurity1.model.LoginResponse;
import edu.miu.springsecurity1.model.RefreshTokenRequest;

public interface UaaService {
    LoginDtoResponse login(LoginDtoRequest loginRequest);

    LoginDtoResponse refreshToken(RefreshTokenDtoRequest refreshTokenRequest);

    SignUpDtoResponse signup(SignUpDtoRequest signUpRequest);
}
