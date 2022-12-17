package com.example.lab3springdata.dto.roleDto;


import com.example.lab3springdata.entity.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
public class RoleBasicDto {

    private int id;
    private String role;
    @JsonIgnoreProperties("roles")
    private List<User> users;



}
