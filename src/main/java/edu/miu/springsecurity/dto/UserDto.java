package edu.miu.springsecurity.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
public class UserDto {
    private int id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;

    @JsonIgnoreProperties("user")
    private AddressDto address;

    @JsonIgnoreProperties("user")
    private List<ReviewDto> reviews;
}
