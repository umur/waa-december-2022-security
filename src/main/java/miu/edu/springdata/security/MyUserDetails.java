package miu.edu.springdata.security;

import com.fasterxml.jackson.annotation.JsonIgnore;
import miu.edu.springdata.dto.UserDto;
import miu.edu.springdata.entity.Role;
import miu.edu.springdata.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Locale;

public class MyUserDetails implements UserDetails {

    private int userId;
    private String email;
    private String firstname;
    private String lastname;
    @JsonIgnore
    private String  password;
    private List<Role> roles;

    public MyUserDetails(UserDto user){
        this.userId = user.getId();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.roles = user.getRoles();
        this.firstname = user.getFirstname();
        this.lastname = user.getLastname();
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        var result = roles.stream()
                .map(role-> new SimpleGrantedAuthority("ROLE_"+role.getRole().toUpperCase(Locale.ROOT)))
                .toList();
        return result;
    }

    public int getUserId() {
        return userId;
    }
    public String getFirstname() {
        return firstname;
    }
    public String getLastname() {
        return lastname;
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
