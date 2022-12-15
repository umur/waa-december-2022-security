package miu.edu.springdata.dto;

import lombok.Data;
import miu.edu.springdata.entity.Role;

import java.util.List;

@Data
public class UserDto {
    private int id;
    private String email;
    private String password;
    private String firstname;
    private String lastname;

    private List<Role> roles;
}
