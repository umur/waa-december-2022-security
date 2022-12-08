package com.ujjwal.humagain.springdata.entity.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class ReviewDto {
    private int id;
    private String comment;
    @JsonIgnore
    private ProductDto product;
    @JsonIgnore
    private UserDto user;
}
