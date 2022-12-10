package edu.miu.springsecurity.service.impl;

import edu.miu.springsecurity.dto.UserDto;
import edu.miu.springsecurity.entity.User;
import edu.miu.springsecurity.model.LoginRequest;
import edu.miu.springsecurity.model.LoginResponse;
import edu.miu.springsecurity.repository.UserRepo;
import edu.miu.springsecurity.security.JwtHelper;
import edu.miu.springsecurity.service.UaaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import java.util.Base64;

@Service
@RequiredArgsConstructor
//@Slf4j
public class UaaServiceImpl implements UaaService {

    private final ModelMapper modelMapper;
    private final UserRepo userRepo;
    private final AuthenticationManager authenticationManager;
    private final JwtHelper jwtHelper;

    @Override
    public LoginResponse signIn(LoginRequest loginRequest) {
        try {
            var result = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword())
            );
            var reau = result;
        } catch(BadCredentialsException e){
            System.out.println("Bad credentials");
        }

        final String accessToken = jwtHelper.generateToken(loginRequest.getEmail());
        var loginResponse = new LoginResponse(accessToken, "");
        return loginResponse;
    }

    @Override
    public void signUp(UserDto userDto){
        //encode password to store in db
        String encoded = Base64.getEncoder().encodeToString(userDto.getPassword().getBytes());
        userDto.setPassword(encoded);
        userRepo.save(modelMapper.map(userDto, User.class));
    }
}
