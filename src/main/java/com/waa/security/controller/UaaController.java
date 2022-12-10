package com.waa.security.controller;
import com.waa.security.entity.User;
import com.waa.security.model.LoginRequest;
import com.waa.security.service.UaaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping()
@CrossOrigin
@RequiredArgsConstructor
public class UaaController {

    private final UaaService uaaService;


    @PostMapping("/login")
    public ResponseEntity<?> loginPost(@RequestBody LoginRequest loginRequest) {
        var loginResponse = uaaService.login(loginRequest);
        return ResponseEntity.ok().body(loginResponse);

    }


    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody User user) {
        uaaService.signUp(user);
        return ResponseEntity.ok().body("User created");

    }
}
