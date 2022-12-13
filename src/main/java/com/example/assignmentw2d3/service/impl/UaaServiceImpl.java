package com.example.assignmentw2d3.service.impl;

import com.example.assignmentw2d3.entity.User;
import com.example.assignmentw2d3.model.LoginRequest;
import com.example.assignmentw2d3.model.LoginResponse;
import com.example.assignmentw2d3.model.RegisterRequest;
import com.example.assignmentw2d3.repo.UserRepo;
import com.example.assignmentw2d3.security.JWTHelper;
import com.example.assignmentw2d3.service.UaaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UaaServiceImpl implements UaaService {
    private final AuthenticationManager authenticationManager;
    private final JWTHelper jwtHelper;
    private final UserRepo userRepo;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public LoginResponse login(LoginRequest loginRequest) throws Exception{
        LoginResponse loginResponse;
        try {
            var result = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword())
            );
            loginResponse = generateAccessAndRefreshToken(loginRequest.getEmail());
        } catch (BadCredentialsException e) {
            log.info(e.getMessage());
            throw new BadCredentialsException(e.getMessage());
        } catch (Exception e) {
            log.info(e.getMessage());
            throw new Exception(e.getMessage());
        }
        return loginResponse;
    }

    @Override
    public LoginResponse register(RegisterRequest registerRequest) throws Exception {
        try {
            User newUser = new User();
            newUser.setEmail(registerRequest.getEmail());
            newUser.setLastname(registerRequest.getLastname());
            newUser.setFirstname(registerRequest.getFirstname());
            newUser.setRoles(registerRequest.getRoles());
            newUser.setPassword(bCryptPasswordEncoder.encode(registerRequest.getPassword()));
            userRepo.save(newUser);
        } catch (Exception e) {
            throw e;
        }
        LoginResponse registerResponse = generateAccessAndRefreshToken(registerRequest.getEmail());
        return registerResponse;
    }

    private LoginResponse generateAccessAndRefreshToken(String username) {
        return new LoginResponse(
          jwtHelper.generateAccessToken(username),
          jwtHelper.generateRefreshToken(username)
        );
    }
}
