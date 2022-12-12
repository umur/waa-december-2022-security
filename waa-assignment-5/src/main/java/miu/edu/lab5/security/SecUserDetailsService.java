package miu.edu.lab5.security;

import miu.edu.lab5.entity.User;
import miu.edu.lab5.repository.UserRepo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service("userDetailsService")
@Transactional
public class SecUserDetailsService implements UserDetailsService {

    private final UserRepo userRepo;

    public SecUserDetailsService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByEmail(username);

        var userDetails = new SecUserDetails(user);


        return userDetails;

    }
}
