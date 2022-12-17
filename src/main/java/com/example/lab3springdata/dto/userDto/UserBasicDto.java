package com.example.lab3springdata.dto.userDto;
import com.example.lab3springdata.entity.Review;
import com.example.lab3springdata.entity.Role;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserBasicDto {

    private int id;
    private String email;
    private String password;
    private String firstName;
    private String lastname;
    private List<Review> reviews;
  @JsonIgnoreProperties("users")
    private List<Role> roles;


}
