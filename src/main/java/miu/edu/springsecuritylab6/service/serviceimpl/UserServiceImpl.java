package miu.edu.springsecuritylab6.service.serviceimpl;

import miu.edu.springsecuritylab6.domain.User;
import miu.edu.springsecuritylab6.domain.UserPrincipal;
import miu.edu.springsecuritylab6.enumeration.Role;
import miu.edu.springsecuritylab6.exception.EmailExistException;
import miu.edu.springsecuritylab6.exception.UsernameExistException;
import miu.edu.springsecuritylab6.repository.UserRepository;
import miu.edu.springsecuritylab6.service.UserService;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;

@Service
@Transactional
@Qualifier("UserDetailsService")
public class UserServiceImpl implements UserService, UserDetailsService {


    private UserRepository userRepository;

    private BCryptPasswordEncoder bCryptPasswordEncoder;
    private Logger LOGGER = LoggerFactory.getLogger(getClass());

    @Autowired
    public UserServiceImpl(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = passwordEncoder;

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findUserByUsername(username);
        if (user == null) {
            LOGGER.error("Username is not found " + username);
            throw new UsernameNotFoundException("Username is not found " + username);
        } else {
            user.setLastLoginDateDisplay(user.getLastLoginDate());
            user.setLastLoginDate(new Date());
            userRepository.save(user);
            UserPrincipal userPrincipal = new UserPrincipal(user);
            LOGGER.info("Returning found user by username " + user);
            return userPrincipal;
        }
    }

    @Override
    public User findUserByUsername(String username) {
        return userRepository.findUserByUsername(username);
    }

    @Override
    public User findUserByEmail(String username) {
        return userRepository.findUserByEmail(username);
    }

    @Override
    public User register(String firstName, String lastName, String username, String email) throws EmailExistException, UsernameExistException {
        validateNewUsernameAndPassword(StringUtils.EMPTY, username, email);

        User newUser = new User();
        String password = generatePassword();
        String encodePassword = encoderPassword(password);
        newUser.setFirstName(firstName);
        newUser.setLastName(lastName);
        newUser.setUsername(username);
        newUser.setEmail(email);
        newUser.setJoinDate(new Date());
        newUser.setPassword(encodePassword);
        newUser.setActive(true);
        newUser.setNotLocked(true);
        newUser.setRoles(Role.ROLE_USER.name());
        System.out.println("User role : "+Role.ROLE_USER.name());
        newUser.setAuthorities(Role.ROLE_USER.getAuthorities());

        userRepository.save(newUser);
        LOGGER.info("New User password: "+password);
        return  newUser;
    }

    private String encoderPassword(String password) {
        return bCryptPasswordEncoder.encode(password);
    }

    private String generateUserId() {
        return RandomStringUtils.randomNumeric(10);
    }

    private String generatePassword() {
        return RandomStringUtils.randomAlphanumeric(10);

    }

    private User validateNewUsernameAndPassword(String currentUsername, String newUsername, String newEmail) throws EmailExistException, UsernameExistException {
        if(StringUtils.isNotEmpty(currentUsername)){
            User currentUser = findUserByUsername(currentUsername);

            if( currentUser == null){
                throw new UsernameNotFoundException("No user found by username "+currentUsername);
            }

            User userByUsername = findUserByUsername(newUsername);
            if(userByUsername != null && !currentUser.getId().equals(userByUsername.getId())){
                throw new UsernameNotFoundException("Username already exits");
            }
            User userByEmail = findUserByEmail(newEmail);
            if(userByEmail != null && !currentUser.getId().equals(userByEmail.getId())){
                throw new EmailExistException("Username already exits");
            }

            return currentUser;


        }else {
            User userByUsername = findUserByUsername(newUsername);
            System.out.println("i am consoling..."+newUsername);
            if(userByUsername != null){
                throw new UsernameExistException("Username already exist");
            }

            User userByEmail = findUserByEmail(newEmail);
            if(userByEmail != null){
                throw new EmailExistException("Email already exists");
            }
            return null;
        }
    }
}
