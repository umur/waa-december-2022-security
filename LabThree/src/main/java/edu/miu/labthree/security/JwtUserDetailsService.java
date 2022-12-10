package edu.miu.labthree.security;

import edu.miu.labthree.entity.User;
import edu.miu.labthree.repository.UserRepo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {
    private final UserRepo userRepo;

    public JwtUserDetailsService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        User user = userRepo.findByEmail(username);
        var userDetails = new ZUserDetails(user);
        return userDetails;
    }
}
