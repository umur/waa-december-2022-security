package edu.miu.mae.controller;

import edu.miu.mae.model.SignupRequest;
import edu.miu.mae.service.UaaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import edu.miu.mae.model.LoginRequest;
import edu.miu.mae.model.LoginResponse;
import edu.miu.mae.model.RefreshTokenRequest;
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

    //toDo signout
//    @PostMapping
//    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
//        var loginResponse = uaaService.login(loginRequest);
//        return ResponseEntity.ok().body(loginResponse);
//    }
    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody SignupRequest signUpRequest) {
        var signUpResponse = uaaService.signUp(signUpRequest);
        return ResponseEntity.ok().body(signUpResponse);
    }


    @PostMapping("/refreshToken")
    public LoginResponse refreshToken(@RequestBody RefreshTokenRequest refreshTokenRequest){
        return uaaService.refreshToken(refreshTokenRequest);
    }

}
