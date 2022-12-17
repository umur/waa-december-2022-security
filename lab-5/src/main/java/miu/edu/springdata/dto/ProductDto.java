package miu.edu.springdata.dto;

import lombok.Data;

@Data
public class ProductDto {
    private int id;
    private String name;
    private double price;
    private double rating;
//    private int categor_id;
}
