package com.w1d3.springdata.controller;

import com.w1d3.springdata.entity.model.LoginRequest;
import com.w1d3.springdata.service.UaaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/uaa")
@RequiredArgsConstructor
public class UaaController {
    private final UaaService uaaService;

    @PostMapping
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest){
    var loginResponse=uaaService.login(loginRequest);
    return ResponseEntity.ok().body(loginResponse);
    }


}
