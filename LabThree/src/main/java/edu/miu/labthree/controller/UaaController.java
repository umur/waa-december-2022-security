package edu.miu.labthree.controller;

import edu.miu.labthree.model.SignInRequest;
import edu.miu.labthree.model.SignInResponse;
import edu.miu.labthree.service.UaaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.List;

@RestController
@RequestMapping("/uaa")
@CrossOrigin
public class UaaController {

    private final UaaService uaaService;


    public UaaController(UaaService uaaService) {
        this.uaaService = uaaService;
    }

    @GetMapping("/")
    public String adminLogin(){
        return null;
    }

    @GetMapping("/products")
    public SignInResponse userLogin(){
        return null;
    }

    @GetMapping
    public ResponseEntity<List<?>> signIn(@RequestBody SignInRequest request) {
        // there needs to a logic to give out access and refresh token.
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @PostMapping("/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody SignInRequest authenticationRequest)
            throws Exception {
        return ResponseEntity.ok(uaaService.accessToken(authenticationRequest));
    }

    @PostMapping("/refreshToken")
    public ResponseEntity<?> refreshToken(@RequestBody SignInResponse refreshTokenRequest) {
        return ResponseEntity.ok(uaaService.refreshToken(refreshTokenRequest));
    }
}
