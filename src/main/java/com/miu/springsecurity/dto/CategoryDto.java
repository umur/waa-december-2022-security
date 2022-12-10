package com.miu.springsecurity.dto;

import com.miu.springsecurity.entity.Product;
import lombok.Data;

import java.util.List;

@Data
public class CategoryDto {
    private int id;
    private String name;
    private List<Product> products;
}
