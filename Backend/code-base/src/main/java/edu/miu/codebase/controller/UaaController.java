package edu.miu.codebase.controller;

import edu.miu.codebase.model.LoginRequest;
import edu.miu.codebase.model.LoginResponse;
import edu.miu.codebase.model.RefreshTokenRequest;
import edu.miu.codebase.service.UaaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/authenticate")
@CrossOrigin(origins = "http://localhost:3000")
public class UaaController {

    private final UaaService uaaService;

    public UaaController(UaaService uaaService) {
        this.uaaService = uaaService;
    }

    @PostMapping
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        var loginResponse = uaaService.login(loginRequest);
        return ResponseEntity.ok().body(loginResponse);
    }

    @PostMapping("/refreshToken")
    public LoginResponse refreshToken(@RequestBody RefreshTokenRequest refreshTokenRequest){
        return uaaService.refreshToken(refreshTokenRequest);
    }

}
