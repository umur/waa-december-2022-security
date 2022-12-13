package com.example.assignmentw2d3.controller;

import com.example.assignmentw2d3.model.LoginRequest;
import com.example.assignmentw2d3.model.LoginResponse;
import com.example.assignmentw2d3.model.RegisterRequest;
import com.example.assignmentw2d3.service.UaaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/uaa")
public class UaaController {
    private final UaaService uaaService;

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest loginRequest) throws Exception{
        return uaaService.login(loginRequest);
    }

    @PostMapping("/register")
    public LoginResponse register(@RequestBody RegisterRequest registerRequest) throws Exception{
        return uaaService.register(registerRequest);
    }
}
