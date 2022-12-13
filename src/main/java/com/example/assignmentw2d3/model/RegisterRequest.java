package com.example.assignmentw2d3.model;

import com.example.assignmentw2d3.entity.Role;
import lombok.Data;

import java.util.List;

@Data
public class RegisterRequest {
    private String email;
    private String password;
    private String lastname;
    private String firstname;
    private List<Role> roles;
}
