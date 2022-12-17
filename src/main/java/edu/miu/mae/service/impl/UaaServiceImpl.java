package edu.miu.mae.service.impl;


import edu.miu.mae.constatans.ERole;
import edu.miu.mae.dto.UserDto;
import edu.miu.mae.entity.Role;
import edu.miu.mae.entity.User;
import edu.miu.mae.model.*;
import edu.miu.mae.repository.RoleRepository;
import edu.miu.mae.repository.UserRepository;
import edu.miu.mae.security.JwtHelper;
import edu.miu.mae.service.UaaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;
@Service
@RequiredArgsConstructor
@Slf4j
public class UaaServiceImpl implements UaaService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    PasswordEncoder encoder;
    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;
    private final JwtHelper jwtHelper;

    @Autowired
    private RoleRepository repository;


    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        try {
            var result = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getEmail(),
                            loginRequest.getPassword())
            );
        } catch (BadCredentialsException e) {
            log.info("Bad Credentials");
        }

        final String accessToken = jwtHelper.generateToken(loginRequest.getEmail());
        final String refreshToken = jwtHelper.generateRefreshToken(loginRequest.getEmail());
        var loginResponse = new LoginResponse(accessToken, refreshToken);
        return loginResponse;
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
    public SignupResponse signUp(SignupRequest signUpRequest) {

            // Create new user's account
          User user = new User(signUpRequest.getEmail(),
                    encoder.encode(signUpRequest.getPassword()),
                    signUpRequest.getFirstName(),signUpRequest.getLastName(),signUpRequest.getAddress());

            Set<String> strRoles = signUpRequest.getRole();
            List<Role> roles = new ArrayList<>();

            if (strRoles == null) {
                Role userRole = repository.findByRole(ERole.USER.name());
                roles.add(userRole);
            } else {
                strRoles.forEach(role -> {
                    switch (role) {
                        case "ADMIN":
                            Role adminRole = repository.findByRole(ERole.ADMIN.name());
                            roles.add(adminRole);

                            break;
                        default:
                            Role userRole = repository.findByRole(ERole.USER.name());
                            roles.add(userRole);
                    }
                });
            }

            user.setRoles(roles);
            userRepository.save(user);

            return new SignupResponse("User registered successfully!");
        }

//        try {
//            var result = authenticationManager.authenticate(
//                    new UsernamePasswordAuthenticationToken(loginRequest.getEmail(),
//                            loginRequest.getPassword())
//            );
//        } catch (BadCredentialsException e) {
//            log.info("Bad Credentials");
//        }

//        final String accessToken = jwtHelper.generateToken(loginRequest.getEmail());
//        final String refreshToken = jwtHelper.generateRefreshToken(loginRequest.getEmail());
//        var loginResponse = new LoginResponse(accessToken, refreshToken);
//        return loginResponse;
 }

