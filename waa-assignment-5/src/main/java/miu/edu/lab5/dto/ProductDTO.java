package miu.edu.lab5.dto;


import lombok.Data;
import miu.edu.lab5.entity.Category;
import miu.edu.lab5.entity.Review;

@Data
public class ProductDTO {
    private int id;
    private String name;
    private int rating;
    private Category category;
    private Review reviews;
}
