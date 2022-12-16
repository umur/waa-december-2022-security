package com.example.lab6.Service.ServiceImpl;

import com.example.lab6.Security.JwtHelper;
import com.example.lab6.Service.uaaService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Log4j2
public class uaaServiceImpl implements uaaService {

    private final JwtHelper jwtHelper;
    private final AuthenticationManager manager;

//    private final ModelMapper mapper;

    @Override
    public Map<String, String> login(Map<String, String> body) {
        String username = body.get("username");
        String password = body.get("password");
        var request = new UsernamePasswordAuthenticationToken(username, password);
        final String accessToken = jwtHelper.generateToken(username);
        final String refreshToken = jwtHelper.generateRefreshToken(password);
        Map<String, String> tokenBody = new HashMap<>();
        tokenBody.put("access_token", accessToken);
        tokenBody.put("refresh_token", refreshToken);
        manager.authenticate(request);
        return tokenBody;
    }

    @Override
    public Map<String, String> refresh(String refreshToken) {
        boolean isRefreshTokenValid = jwtHelper.validateToken(refreshToken);
        if (isRefreshTokenValid) {
            final String accessToken = jwtHelper.generateToken(jwtHelper.getSubject(refreshToken));
            Map<String, String> tokenBody = new HashMap<>();
            tokenBody.put("access_token", accessToken);
            tokenBody.put("refresh_token", refreshToken);
            return tokenBody;
        }
        return new HashMap<>();
    }

    @Override
    public Map<String, Boolean> validate() {
        return new HashMap<>();
    }
}
