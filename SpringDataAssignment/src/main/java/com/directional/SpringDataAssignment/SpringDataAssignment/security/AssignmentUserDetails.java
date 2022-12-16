package com.directional.SpringDataAssignment.SpringDataAssignment.security;

import com.directional.SpringDataAssignment.SpringDataAssignment.Entity.BiDirectional.Role;
import com.directional.SpringDataAssignment.SpringDataAssignment.Entity.BiDirectional.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Locale;

public class AssignmentUserDetails implements UserDetails {

    private String email;
    @JsonIgnore
    private String password;

    private List<Role> roles;

    public AssignmentUserDetails(User user) {
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.roles = user.getRoles();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles.stream().map(role -> new SimpleGrantedAuthority("Role_" + role.getRole().toUpperCase(Locale.ROOT))).toList();
    }

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
