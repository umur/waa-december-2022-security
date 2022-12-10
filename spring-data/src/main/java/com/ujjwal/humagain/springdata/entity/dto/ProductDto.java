package com.ujjwal.humagain.springdata.entity.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ujjwal.humagain.springdata.entity.Category;
import lombok.Data;

import java.util.List;

@Data
public class ProductDto {
    private int id;
    private String name;
    private int price;
    private int rating;
    private CategoryDto category;
    private UserDto user;
    @JsonIgnore
    private List<ReviewDto> reviewList;
}
