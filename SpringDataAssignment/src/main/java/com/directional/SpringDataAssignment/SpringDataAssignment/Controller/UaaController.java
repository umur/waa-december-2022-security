package com.directional.SpringDataAssignment.SpringDataAssignment.Controller;

import com.directional.SpringDataAssignment.SpringDataAssignment.Entity.BiDirectional.User;
import com.directional.SpringDataAssignment.SpringDataAssignment.Service.UaaService;
import com.directional.SpringDataAssignment.SpringDataAssignment.model.LoginRequest;
import com.directional.SpringDataAssignment.SpringDataAssignment.model.LoginResponse;
import com.directional.SpringDataAssignment.SpringDataAssignment.model.RefreshTokenRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/uaa")
@CrossOrigin
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

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody User user)
    {
        var loginResponse = uaaService.signUp(user);
        return ResponseEntity.ok().body(loginResponse);
    }

}
