package edu.miu.labthree.security;

import com.fasterxml.jackson.annotation.JsonIgnore;
import edu.miu.labthree.entity.Roles;
import edu.miu.labthree.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class ZUserDetails implements UserDetails {

    private String email;

    @JsonIgnore
    private String password;

    private List<Roles> rolesList;

    public ZUserDetails(User user) {
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.rolesList = user.getRoles();
    }

    @Override public Collection<? extends GrantedAuthority> getAuthorities() {
        return rolesList.stream()
                .map(eachRole -> new SimpleGrantedAuthority(eachRole.name()))
                .toList();
    }

    @Override public String getPassword() {
        return password;
    }

    @Override public String getUsername() {
        return email;
    }

    @Override public boolean isAccountNonExpired() {
        return true;
    }

    @Override public boolean isAccountNonLocked() {
        return true;
    }

    @Override public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override public boolean isEnabled() {
        return true;
    }
}
