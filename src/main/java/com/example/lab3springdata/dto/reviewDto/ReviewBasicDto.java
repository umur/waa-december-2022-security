package com.example.lab3springdata.dto.reviewDto;

import com.example.lab3springdata.entity.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReviewBasicDto {
    private int id;
    private String comment;
    private Product product;

}
