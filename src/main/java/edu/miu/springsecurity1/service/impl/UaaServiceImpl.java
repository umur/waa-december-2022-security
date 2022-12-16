package edu.miu.springsecurity1.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import edu.miu.springsecurity1.dto.UserDTO;
import edu.miu.springsecurity1.entity.Role;
import edu.miu.springsecurity1.entity.User;
import edu.miu.springsecurity1.model.LoginRequest;
import edu.miu.springsecurity1.model.LoginResponse;
import edu.miu.springsecurity1.model.RefreshTokenRequest;
import edu.miu.springsecurity1.model.SignUpResponse;
import edu.miu.springsecurity1.repository.UserRepo;
import edu.miu.springsecurity1.security.JwtHelper;
import edu.miu.springsecurity1.service.UaaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class UaaServiceImpl implements UaaService {

    private final AuthenticationManager authenticationManager;
    private final JwtHelper jwtHelper;
    private final UserRepo userRepo;
    private final ModelMapper modelMapper;
    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getEmail(),
                            loginRequest.getPassword()));
        } catch (BadCredentialsException e) {
            log.info("Bad Credentials");
        }

        final String accessToken = jwtHelper.generateToken(loginRequest.getEmail());
        final String refreshToken = jwtHelper.generateRefreshToken(loginRequest.getEmail());
        return new LoginResponse(accessToken, refreshToken);
    }

    @Override
    public LoginResponse refreshToken(RefreshTokenRequest refreshTokenRequest) {
        boolean isRefreshTokenValid = jwtHelper.validateToken(refreshTokenRequest.getRefreshToken());
        if (isRefreshTokenValid) {
            final String accessToken = jwtHelper
                    .generateToken(jwtHelper.getSubject(refreshTokenRequest.getRefreshToken()));
            return new LoginResponse(accessToken, refreshTokenRequest.getRefreshToken());
        }
        return new LoginResponse();
    }

    @Override
    public SignUpResponse signUp(UserDTO userDTO) {
        User foundedUser = userRepo.findByEmail(userDTO.getEmail());

        if (foundedUser == null) {
            User user = modelMapper.map(userDTO, User.class);
            List<Role> roles = new ArrayList<>();
            roles.add(new Role(2, "USER"));
            user.setRoles(roles);
            user.setPassword(passwordEncoder.encode(userDTO.getPassword()));

            try {
                userRepo.save(user);
                return new SignUpResponse(true, "Successfully created!");
            } catch (Exception e) {
                e.printStackTrace();
                return new SignUpResponse(false, e.getMessage());
            }
        } else {
            return new SignUpResponse(false, "User is already created!");
        }
    }
}
