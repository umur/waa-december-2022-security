package com.directional.SpringDataAssignment.SpringDataAssignment.Service;

import com.directional.SpringDataAssignment.SpringDataAssignment.Entity.BiDirectional.User;
import com.directional.SpringDataAssignment.SpringDataAssignment.model.LoginRequest;
import com.directional.SpringDataAssignment.SpringDataAssignment.model.LoginResponse;
import com.directional.SpringDataAssignment.SpringDataAssignment.model.RefreshTokenRequest;

public interface UaaService {
    LoginResponse login(LoginRequest Request);
    LoginResponse refreshToken(RefreshTokenRequest refreshTokenRequest);

    LoginResponse signUp(User user);

}
