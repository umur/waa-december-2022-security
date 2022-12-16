package edu.miu.springsecurity1.service;

import edu.miu.springsecurity1.dto.UserDTO;
import edu.miu.springsecurity1.model.LoginRequest;
import edu.miu.springsecurity1.model.LoginResponse;
import edu.miu.springsecurity1.model.RefreshTokenRequest;
import edu.miu.springsecurity1.model.SignUpResponse;

public interface UaaService {
    LoginResponse login(LoginRequest loginRequest);
    LoginResponse refreshToken(RefreshTokenRequest refreshTokenRequest);
    
    SignUpResponse signUp(UserDTO userDTO);
}
