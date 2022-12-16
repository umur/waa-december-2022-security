package com.directional.SpringDataAssignment.SpringDataAssignment.security;

import com.directional.SpringDataAssignment.SpringDataAssignment.Entity.BiDirectional.User;
import com.directional.SpringDataAssignment.SpringDataAssignment.Repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class AssignmentUserDetailService implements UserDetailsService {

    public final UserRepo userRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByEmail(username);

        AssignmentUserDetails assignmentUserDetails = new AssignmentUserDetails(user);
        return  assignmentUserDetails;
    }
}
