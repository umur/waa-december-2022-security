package miu.edu.springdata.dto;

import lombok.Data;
import miu.edu.springdata.entity.Category;

@Data
public class ProductDto {
    private int id;
    private String name;
    private double price;
    private double rating;
    private Category category;
//    private int categor_id;
}
