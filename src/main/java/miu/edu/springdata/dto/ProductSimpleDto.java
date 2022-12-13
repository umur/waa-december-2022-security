package miu.edu.springdata.dto;

import lombok.Data;

@Data
public class ProductSimpleDto {
    private int id;
    private String name;
    private double price;
    private double rating;
}
