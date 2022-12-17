package miu.edu.springsecuritylab6.resource;

import miu.edu.springsecuritylab6.constant.SecurityConstant;
import miu.edu.springsecuritylab6.domain.User;
import miu.edu.springsecuritylab6.domain.UserPrincipal;
import miu.edu.springsecuritylab6.exception.EmailExistException;
import miu.edu.springsecuritylab6.exception.UsernameExistException;
import miu.edu.springsecuritylab6.service.UserService;
import miu.edu.springsecuritylab6.utility.JWTTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class UaaController {

    private UserService userService;

    private JWTTokenProvider jwtTokenProvider;

    private AuthenticationManager authenticationManager;

    @Autowired
    public UaaController(UserService userService, AuthenticationManager authenticationManager, JWTTokenProvider jwtTokenProvider) {
        this.userService = userService;
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
    }


    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody User user) {
        authenticationManager(user.getUsername(), user.getPassword());
        User newUser = userService.findUserByUsername(user.getUsername());
        UserPrincipal userPrincipal = new UserPrincipal(newUser);

        HttpHeaders jwtHeader = generateJwtHeader(userPrincipal);

        return new ResponseEntity<>(newUser, jwtHeader, HttpStatus.OK);

    }


    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user) throws EmailExistException, UsernameExistException {
        User newUser = userService.register(user.getFirstName(), user.getLastName(), user.getUsername(), user.getEmail());
        return new ResponseEntity<>(newUser, HttpStatus.OK);
    }



    private HttpHeaders generateJwtHeader(UserPrincipal userPrincipal) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(SecurityConstant.JWT_TOKEN_HEADER, jwtTokenProvider.generateJwtToken(userPrincipal));
        return httpHeaders;
    }

    private void authenticationManager(String username, String password) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));

    }
}
