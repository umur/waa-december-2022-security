package edu.miu.labthree.dto;

import edu.miu.labthree.entity.Category;
import lombok.Data;

@Data
public class ProductDto {
    private int id;
    private String name;
    private int price;
    private double rating;
    private Category category;
}
