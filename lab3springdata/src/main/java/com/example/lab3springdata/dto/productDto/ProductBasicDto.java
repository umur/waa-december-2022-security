package com.example.lab3springdata.dto.productDto;



import com.example.lab3springdata.entity.Address;
import com.example.lab3springdata.entity.Category;
import com.example.lab3springdata.entity.Review;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class ProductBasicDto {
    private int id;
    private String name;
    private int price;
    private int rating;
    private Category category;
    private List<Review> reviews;
    private Address address;
}
