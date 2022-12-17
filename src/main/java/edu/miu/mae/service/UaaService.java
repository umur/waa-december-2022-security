package edu.miu.mae.service;

import edu.miu.mae.model.*;

public interface UaaService {
    LoginResponse login(LoginRequest loginRequest);
    LoginResponse refreshToken(RefreshTokenRequest refreshTokenRequest);
    public SignupResponse signUp(SignupRequest signUpRequest) ;
}
