package com.example.lab6.Security;

import com.example.lab6.Entity.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.management.relation.Role;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class AwesomeUserDetails implements UserDetails {

    private String email;

    @JsonIgnore
    private String password;

    private List<Role> roles;


    public AwesomeUserDetails(User user) {

        this.email = String.valueOf(user.getEmail());
        this.password = String.valueOf(user.getPassword());
        this.roles = user.getRoles();
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        var result= roles.stream()
                // ??????
                .map(role -> new SimpleGrantedAuthority("ROLE_"+ role.getRoleName().toUpperCase(Locale.ROOT)))
                .collect(Collectors.toList());
        return result;
    }

//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return roles.stream()
//                .map(role -> new SimpleGrantedAuthority(role.getRole()))
//                .collect(Collectors.toList());
//    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
