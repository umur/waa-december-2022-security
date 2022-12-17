package edu.miu.lab5.service;

import edu.miu.lab5.entity.User;
import edu.miu.lab5.model.LoginRequest;
import edu.miu.lab5.model.LoginResponse;
import edu.miu.lab5.model.RefreshTokenRequest;
import org.springframework.stereotype.Service;

@Service
public interface UaaService {
    LoginResponse login(LoginRequest loginRequest);

    LoginResponse refreshToken(RefreshTokenRequest refreshTokenRequest);

    void signUp(User user);
}
