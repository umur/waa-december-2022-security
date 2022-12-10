package edu.miu.labthree.dto;

import edu.miu.labthree.entity.Product;
import lombok.Data;

import java.util.List;
@Data
public class CategoryDto {
    private int id;
    private String name;
    private List<Product> productsList;
}
