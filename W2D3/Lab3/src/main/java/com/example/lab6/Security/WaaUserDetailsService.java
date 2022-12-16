package com.example.lab6.Security;


import com.example.lab6.Repository.UserRepo;
import com.example.lab6.Service.Userservice;
import lombok.RequiredArgsConstructor;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service("userDetailsService")
@Transactional
@RequiredArgsConstructor
public class WaaUserDetailsService implements Userservice {

    private final UserRepo repository;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = repository.findByEmail(username);
        if (user.isPresent()) {
            return new WaaUserDetails(user.get());
        }
        throw new UsernameNotFoundException("User not found");
    }

    @Override
    public void saveOrUpdate(com.example.lab6.Entity.User user) {

    }

    @Override
    public List<com.example.lab6.Entity.User> getAll() {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public com.example.lab6.Entity.User getById(int id) {
        return null;
    }
}