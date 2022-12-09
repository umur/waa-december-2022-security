package miu.edu.springdata.controller;

import lombok.RequiredArgsConstructor;
import miu.edu.springdata.model.LoginRequest;
import miu.edu.springdata.service.UaaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/uaa")
@RequiredArgsConstructor
public class UaaController {
    private final UaaService uaaService;

    @PostMapping
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest){
        var loginResponse = uaaService.login(loginRequest);
        return ResponseEntity.ok().body(loginResponse);
    }

}
