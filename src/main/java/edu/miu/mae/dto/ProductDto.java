package edu.miu.mae.dto;

import edu.miu.mae.entity.Review;
import lombok.Data;

import java.util.List;

@Data
public class ProductDto {
    private int id;
    private String name;
    private double price;
    private double rating;
    private List<ReviewDto> reviewsList;
    private String createdByUserEmail;
    @Override
    public String toString() {
        return "ProductDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", rating=" + rating +
                ", reviewsList=" + reviewsList +
                '}';
    }

}
