package com.ujjwal.humagain.springdata.entity.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ujjwal.humagain.springdata.entity.Address;
import com.ujjwal.humagain.springdata.entity.Review;
import lombok.Data;

import java.util.List;

@Data
public class UserDto {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    @JsonIgnore
    private Address address;
    @JsonIgnore
    private List<Review> reviewList;

}
