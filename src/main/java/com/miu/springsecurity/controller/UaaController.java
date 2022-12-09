package com.miu.springsecurity.controller;

import com.miu.springsecurity.dto.UserDto;
import com.miu.springsecurity.model.LoginRequest;
import com.miu.springsecurity.model.LoginResponse;
import com.miu.springsecurity.service.UaaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/uaa")
@RequiredArgsConstructor
public class UaaController {

    private final UaaService uaaService;

    @PostMapping("/signin")
    public LoginResponse signin(@RequestBody LoginRequest loginRequest){
        return uaaService.signIn(loginRequest);
    }

    @PostMapping("/signup")
    public LoginResponse signup(@RequestBody UserDto userDto){
        return uaaService.singUp(userDto);
    }


}
