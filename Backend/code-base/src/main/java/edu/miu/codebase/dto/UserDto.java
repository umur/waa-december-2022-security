package edu.miu.codebase.dto;

import edu.miu.codebase.entity.Address;
import edu.miu.codebase.entity.Role;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@RequiredArgsConstructor
public class UserDto {
    private int id;
    private String email;
    private String firstName;
    private String lastName;
    private Address address;
    private List<Role> roles;
}
