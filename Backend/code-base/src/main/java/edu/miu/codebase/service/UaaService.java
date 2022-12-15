package edu.miu.codebase.service;

import edu.miu.codebase.model.LoginRequest;
import edu.miu.codebase.model.LoginResponse;
import edu.miu.codebase.model.RefreshTokenRequest;

public interface UaaService {
    LoginResponse login(LoginRequest loginRequest);
    LoginResponse refreshToken(RefreshTokenRequest refreshTokenRequest);
}
