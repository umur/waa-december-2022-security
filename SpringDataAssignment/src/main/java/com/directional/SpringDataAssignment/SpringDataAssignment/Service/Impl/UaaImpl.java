package com.directional.SpringDataAssignment.SpringDataAssignment.Service.Impl;

import com.directional.SpringDataAssignment.SpringDataAssignment.Entity.BiDirectional.User;
import com.directional.SpringDataAssignment.SpringDataAssignment.Repository.UserRepo;
import com.directional.SpringDataAssignment.SpringDataAssignment.Service.UaaService;
import com.directional.SpringDataAssignment.SpringDataAssignment.model.LoginRequest;
import com.directional.SpringDataAssignment.SpringDataAssignment.model.LoginResponse;
import com.directional.SpringDataAssignment.SpringDataAssignment.model.RefreshTokenRequest;
import com.directional.SpringDataAssignment.SpringDataAssignment.security.JwtHelper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.security.SecureRandom;

@Service
@RequiredArgsConstructor
@Slf4j
public class UaaImpl implements UaaService {
    private final UserRepo userRepo;

    private final AuthenticationManager authenticationManager;
    private final JwtHelper jwtHelper;

    private final BCryptPasswordEncoder pwdEnc;

    @Override
    public LoginResponse login(LoginRequest request) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    request.getEmail(),
                    request.getPassword()
            ));
        } catch (BadCredentialsException e) {
            log.info("Bad Credentials");
        }
        final String accessToken = jwtHelper.generateToken(request.getEmail());
        final String refreshToken = jwtHelper.generateRefreshToken(request.getEmail());
        return new LoginResponse(accessToken, refreshToken);
    }

    @Override
    public LoginResponse refreshToken(RefreshTokenRequest refreshTokenRequest) {
        boolean isRefreshTokenValid = jwtHelper.validateToken(refreshTokenRequest.getRefreshToken());
        if (isRefreshTokenValid) {
            final String accessToken = jwtHelper.generateToken(jwtHelper.getSubject(refreshTokenRequest.getRefreshToken()));
            var loginResponse = new LoginResponse(accessToken, refreshTokenRequest.getRefreshToken());
            return loginResponse;
        }
        return new LoginResponse();
    }

    @Override
    public LoginResponse signUp(User user) {
        {
            try {
                if (user.getEmail() != null && user.getPassword() != null && checkIfUserExist(user)) {
                    encodePassword(user);
                    userRepo.save(user);
                } else throw new Exception();

            } catch (Exception e) {
                log.info("Bad Signup Credentials");
            }
            final String accessToken = jwtHelper.generateToken(user.getEmail());
            final String refreshToken = jwtHelper.generateRefreshToken(user.getEmail());
            return new LoginResponse(accessToken, refreshToken);
        }
    }

    private boolean checkIfUserExist(User user) {
        return userRepo.findByEmail(user.getEmail()) == null ? true : false;
    }

    private boolean encodePassword(User user) {
//        int strength = 12;
//        BCryptPasswordEncoder bCryptPasswordEncoder =
//                new BCryptPasswordEncoder(strength, new SecureRandom());
        user.setPassword(pwdEnc.encode(user.getPassword()));
        return true;
    }
}
