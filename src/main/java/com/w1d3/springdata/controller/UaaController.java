package com.w1d3.springdata.controller;

import com.w1d3.springdata.entity.Role;
import com.w1d3.springdata.entity.User;
import com.w1d3.springdata.entity.model.LoginRequest;
import com.w1d3.springdata.entity.model.LoginResponse;
import com.w1d3.springdata.entity.model.RefreshTokenRequest;

import com.w1d3.springdata.service.UaaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/uaa")
//@RequiredArgsConstructor
public class UaaController {
    private final UaaService uaaService;



    public UaaController(UaaService uaaService) {
        this.uaaService = uaaService;

    }

    @PostMapping
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest){
    var loginResponse=uaaService.login(loginRequest);
    return ResponseEntity.ok().body(loginResponse);
    }

    @PostMapping("/refreshToken")
    public LoginResponse refreshToken(@RequestBody RefreshTokenRequest refreshTokenRequest){
        return uaaService.refreshToken(refreshTokenRequest);
    }


    @PostMapping("/signup")
    public ResponseEntity<?> register(@RequestBody User user){
        uaaService.register(user);
        return ResponseEntity.ok().body("User Registered");


    }

}
