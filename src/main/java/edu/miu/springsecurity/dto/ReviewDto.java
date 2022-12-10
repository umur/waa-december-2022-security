package edu.miu.springsecurity.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
public class ReviewDto {
    private int id;
    private String comment;

    @JsonIgnoreProperties("reviews")
    private ProductDto product;

    @JsonIgnoreProperties("reviews")
    private UserDto user;
}
