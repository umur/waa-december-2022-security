package edu.miu.springsecurity1.controller;

import edu.miu.springsecurity1.Dto.*;
import edu.miu.springsecurity1.model.LoginRequest;
import edu.miu.springsecurity1.model.LoginResponse;
import edu.miu.springsecurity1.model.RefreshTokenRequest;
import edu.miu.springsecurity1.service.UaaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/uaa")
@CrossOrigin
public class UaaController {
    private final UaaService uaaService;

    public UaaController(UaaService uaaService) {
        this.uaaService = uaaService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDtoRequest loginRequest) {
        try {
            var loginResponse = uaaService.login(loginRequest);
            return ResponseEntity.ok().body(loginResponse);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new LoginFailedDtoResponse("Login failed"));
        }
    }

    @PostMapping("/refreshToken")
    public LoginDtoResponse refreshToken(@RequestBody RefreshTokenDtoRequest refreshTokenRequest) {
        return uaaService.refreshToken(refreshTokenRequest);
    }

    @PostMapping("/signup")
    public SignUpDtoResponse signup(@RequestBody SignUpDtoRequest signUpRequest) {
        return uaaService.signup(signUpRequest);
    }
}