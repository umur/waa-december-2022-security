package com.example.lab6.Controller;


import com.example.lab6.Service.ServiceImpl.uaaServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Map;

@RestController
@RequestMapping("api/uaa")
@RequiredArgsConstructor
public class UaaController {

    private final uaaServiceImpl service;

    @PostMapping("signin")
    public Map<String, String> signIn(@RequestBody Map<String, String> body) {
        return service.login(body);
    }

    @GetMapping("validate")
    public Map<String, Boolean> validate() {
        return service.validate();
    }

    @DeleteMapping("signout")
    public void signOut(Principal principal) {

    }
}