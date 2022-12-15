package edu.miu.codebase.dto;

import edu.miu.codebase.entity.Category;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ProductDto {
    private int id;
    private String name;
    private double price;
    private int rating;
    private Category category;
}
