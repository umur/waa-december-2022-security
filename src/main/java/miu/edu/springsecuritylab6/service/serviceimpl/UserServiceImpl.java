package miu.edu.springsecuritylab6.service.serviceimpl;

import miu.edu.springsecuritylab6.domain.User;
import miu.edu.springsecuritylab6.domain.UserPrincipal;
import miu.edu.springsecuritylab6.repository.UserRepository;
import miu.edu.springsecuritylab6.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;

@Service
@Transactional
@Qualifier("UserDetailsService")
public class UserServiceImpl implements UserService, UserDetailsService {


    private UserRepository userRepository;
    private Logger LOGGER = LoggerFactory.getLogger(getClass());

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
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
}
