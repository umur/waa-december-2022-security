package edu.miu.springsecurity1.dto;

import lombok.Data;

@Data
public class UserDTO {
    private String email;
    private String password;
    private String firstname;
    private String lastname;
}
