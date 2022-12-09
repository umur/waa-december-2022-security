package com.w1d3.springdata.dto;

import lombok.Data;

@Data
public class ProductDto {
    private int id;
    private String name;
    private double price;
    private int rating;
}
