package miu.edu.lab5.dto;





import lombok.Data;
import miu.edu.lab5.entity.Product;

import java.util.List;

@Data
public class CategoryDTO {
    private int id;
    private String name;
    private List<Product> products;


}
