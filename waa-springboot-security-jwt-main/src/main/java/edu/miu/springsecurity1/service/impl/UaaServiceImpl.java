package edu.miu.springsecurity1.service.impl;

import edu.miu.springsecurity1.Dto.*;
import edu.miu.springsecurity1.entity.User;
import edu.miu.springsecurity1.entity.Role;
import edu.miu.springsecurity1.model.LoginRequest;
import edu.miu.springsecurity1.model.LoginResponse;
import edu.miu.springsecurity1.model.RefreshTokenRequest;
import edu.miu.springsecurity1.repository.RoleRepo;
import edu.miu.springsecurity1.repository.UserRepo;
import edu.miu.springsecurity1.security.JwtHelper;
import edu.miu.springsecurity1.service.UaaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
@Slf4j
public class UaaServiceImpl implements UaaService {
    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;
    private final UserRepo userRepo;
    private final RoleRepo roleRepo;

    private final JwtHelper jwtHelper;

    @Override
    public LoginDtoResponse login(LoginDtoRequest loginRequest) {
        try {
            var result = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getEmail(),
                            loginRequest.getPassword())
            );

        } catch (BadCredentialsException e) {
            log.info("Bad Credentials");
            throw e;
        }

        final String accessToken = jwtHelper.generateToken(loginRequest.getEmail());
        final String refreshToken = jwtHelper.generateRefreshToken(loginRequest.getEmail());
        var loginResponse = new LoginDtoResponse(accessToken, refreshToken);
        return loginResponse;
    }

    @Override
    public LoginDtoResponse refreshToken(RefreshTokenDtoRequest refreshTokenRequest) {
        boolean isRefreshTokenValid = jwtHelper.validateToken(refreshTokenRequest.getRefreshToken());
        if (isRefreshTokenValid) {
            final String accessToken = jwtHelper.generateToken(jwtHelper.getSubject(refreshTokenRequest.getRefreshToken()));
            var loginResponse = new LoginDtoResponse(accessToken, refreshTokenRequest.getRefreshToken());
            return loginResponse;
        }
        return new LoginDtoResponse();
    }

    @Override
    public SignUpDtoResponse signup(SignUpDtoRequest signUpRequest) {
        User user = new User();
        user.setEmail(signUpRequest.getUserName());
        user.setFirstname(signUpRequest.getFirstName());
        user.setLastname(signUpRequest.getLastName());

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        var encodedPwd = passwordEncoder.encode(signUpRequest.getPassword());
        user.setPassword(encodedPwd);

        var userRole = roleRepo.findById(signUpRequest.getRoleId()).orElse(null);
        var roles = new ArrayList<Role>();
        roles.add(userRole);
        user.setRoles(roles);

        userRepo.save(user);
        return new SignUpDtoResponse(user);
    }
}
