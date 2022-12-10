package miu.edu.springdata.security;

import lombok.RequiredArgsConstructor;
import miu.edu.springdata.dto.UserDto;
import miu.edu.springdata.entity.User;
import miu.edu.springdata.repository.UserRepo;
import miu.edu.springdata.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userDetailsService")
@Transactional
@RequiredArgsConstructor
public class MyUserDetailsService implements UserDetailsService {

    private final UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDto user = userService.findByEmail(username);
        var userDetails = new MyUserDetails(user);
        return userDetails;
    }
}
