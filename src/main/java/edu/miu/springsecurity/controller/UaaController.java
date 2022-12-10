package edu.miu.springsecurity.controller;

import edu.miu.springsecurity.dto.UserDto;
import edu.miu.springsecurity.model.LoginRequest;
import edu.miu.springsecurity.model.LoginResponse;
import edu.miu.springsecurity.service.UaaService;
import edu.miu.springsecurity.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/uaa")
@RestController
@CrossOrigin
public class UaaController {

    public final UaaService uaaService;

    @PostMapping("/signup")
    public void signup(@RequestBody UserDto user){
        uaaService.signUp(user);
    }

    @PostMapping("/signin")
    public LoginResponse login(@RequestBody LoginRequest loginRequest){
        return uaaService.signIn(loginRequest);
    }
}
