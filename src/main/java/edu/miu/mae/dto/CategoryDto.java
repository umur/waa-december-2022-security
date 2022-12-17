package edu.miu.mae.dto;

import edu.miu.mae.entity.Product;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
public class CategoryDto {
    private int id;
    private String name;
    private List<ProductDto> productList ;
}
