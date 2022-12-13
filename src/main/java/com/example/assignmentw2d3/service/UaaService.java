package com.example.assignmentw2d3.service;

import com.example.assignmentw2d3.model.LoginRequest;
import com.example.assignmentw2d3.model.LoginResponse;
import com.example.assignmentw2d3.model.RegisterRequest;

public interface UaaService {
    public LoginResponse login(LoginRequest loginRequest) throws Exception;
    public LoginResponse register(RegisterRequest registerRequest) throws  Exception;
}
