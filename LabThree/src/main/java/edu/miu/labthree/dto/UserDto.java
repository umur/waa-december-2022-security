package edu.miu.labthree.dto;

import edu.miu.labthree.entity.Address;
import lombok.Data;

@Data
public class UserDto {
    private int id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private Address address;
}
