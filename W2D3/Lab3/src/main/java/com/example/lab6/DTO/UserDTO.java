package com.example.lab6.DTO;

import com.example.lab6.Aspects.waaWord;
import lombok.Data;
import java.util.List;

@Data
public class UserDTO {
    private Long id;
    @waaWord
    private String firstname;
    @waaWord
    private String lastname;
    @waaWord
    private String username;
    @waaWord
    private String password;
    @waaWord
    private String email;
    private List<RoleDTO> roles;
}