package edu.miu.mae.service;

import edu.miu.mae.dto.ProductDto;
import edu.miu.mae.dto.ReviewDto;
import edu.miu.mae.entity.Product;

import java.util.List;

public interface ProductService extends BasicService<Product,ProductDto>{
    List<ProductDto> getAllByPriceGreaterThan(double price);
    List<ProductDto> getAllByNameContaining(String keyword);


    List<ReviewDto> getReviewsByProductId(int id);



    List<ProductDto> getAllProductsByCategoryAndPrice(String categoryName, double maxPrice);
}
