package edu.miu.labthree.service.impl;

import edu.miu.labthree.config.JwtTokenUtil;
import edu.miu.labthree.model.SignInRequest;
import edu.miu.labthree.model.SignInResponse;
import edu.miu.labthree.security.JwtUserDetailsService;
import edu.miu.labthree.service.UaaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UaaServiceImpl implements UaaService {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private JwtUserDetailsService userDetailsService;

    @Override
    public SignInResponse accessToken(SignInRequest authRequest) throws Exception {
        authenticate(authRequest.getEmail(), authRequest.getPassword());

        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(authRequest.getEmail());

        final String token = jwtTokenUtil.generateToken(userDetails);
        final String refreshToken = jwtTokenUtil.generateRefreshToken(authRequest.getEmail());

        return new SignInResponse(token, refreshToken);
    }

    @Override public SignInResponse refreshToken(SignInResponse refreshRequest) {
        // check authenticity and validity
        String tokenOwner = jwtTokenUtil.getUsernameFromToken(refreshRequest.getAccessToken());
        final UserDetails userDetails = userDetailsService.loadUserByUsername(tokenOwner);

        boolean isTokenValid = jwtTokenUtil.validateToken(refreshRequest.getRefreshToken(),
                userDetails);

        if(isTokenValid) {
            boolean hasAccessExpired =
                    jwtTokenUtil.getExpirationDateFromToken(refreshRequest.getAccessToken())
                            .before(new Date());
            if(!hasAccessExpired) return refreshRequest;

            // token is authentic and expired, let's give him/her a new one
            final String accessToken = jwtTokenUtil.generateToken(userDetails);
            final String refreshToken = jwtTokenUtil.generateRefreshToken(userDetails.getUsername());

            return new SignInResponse(accessToken, refreshToken);
        }

        return null;
    }

    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}
