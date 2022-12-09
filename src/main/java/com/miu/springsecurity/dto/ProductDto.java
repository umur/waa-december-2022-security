package com.miu.springsecurity.dto;

import com.miu.springsecurity.entity.Category;
import com.miu.springsecurity.entity.Review;
import lombok.Data;

import java.util.List;

@Data
public class ProductDto {
    private int id;
    private String name;
    private double price;
    private double rating;
    private Category category;
    private List<Review> reviews;
}
