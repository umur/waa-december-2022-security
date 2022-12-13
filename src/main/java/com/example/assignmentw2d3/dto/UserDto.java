package com.example.assignmentw2d3.dto;

import com.example.assignmentw2d3.entity.Role;
import lombok.Data;

import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.List;

@Data
public class UserDto {
    private int id;

    private String email;
    private String firstname;
    private String lastname;
    private String password;

    private List<Role> roles;
}
