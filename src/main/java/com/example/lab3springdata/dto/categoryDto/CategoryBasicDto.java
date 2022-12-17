package com.example.lab3springdata.dto.categoryDto;

import com.example.lab3springdata.entity.Product;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CategoryBasicDto {

    private int id;
    private String name;
    private List<Product> products;
}

