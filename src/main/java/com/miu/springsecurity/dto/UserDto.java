package com.miu.springsecurity.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.miu.springsecurity.entity.Address;
import com.miu.springsecurity.entity.Role;
import lombok.Data;

import java.util.List;

@Data
public class UserDto {
    private int id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private Address address;
    @JsonIgnore
    private List<Role> roles;
}
