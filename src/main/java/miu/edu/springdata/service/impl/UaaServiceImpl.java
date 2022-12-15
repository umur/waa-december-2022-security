package miu.edu.springdata.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import miu.edu.springdata.entity.User;
import miu.edu.springdata.model.LoginRequest;
import miu.edu.springdata.model.LoginResponse;
import miu.edu.springdata.repository.RoleRepo;
import miu.edu.springdata.repository.UserRepo;
import miu.edu.springdata.security.JwtHelper;
import miu.edu.springdata.security.MyUserDetails;
import miu.edu.springdata.service.UaaService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
@RequiredArgsConstructor
@Slf4j
public class UaaServiceImpl implements UaaService {

    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final JwtHelper jwtHelper;
    private final RoleRepo roleRepo;
    private final UserRepo userRepo;

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        Authentication result;
        try {
            result = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginRequest.getEmail(),
                            loginRequest.getPassword()
                    )
            );
        } catch (BadCredentialsException e) {
            log.info("Bad Credentials");
            throw e;
        } catch (Exception ex) {
            log.info(ex.getMessage());
            throw ex;
        }
        final String accessToken = jwtHelper.generateToken(loginRequest.getEmail(),
                new HashMap<String, Object>() {{
                    put("firstname", ((MyUserDetails) result.getPrincipal()).getFirstname());
                    put("lastname", ((MyUserDetails) result.getPrincipal()).getLastname());
                    put("sub", loginRequest.getEmail());
                }}
        );
        var loginResponse = new LoginResponse(accessToken);
        return loginResponse;
    }

    @Override
    public void register(User user) {

        var password = user.getPassword();
        user.setPassword(bCryptPasswordEncoder.encode(password));
        user.setRoles(roleRepo.findByRole("GOLD"));
        var response = userRepo.save(user);
    }
}
