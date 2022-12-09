package com.miu.springsecurity.service;

import com.miu.springsecurity.dto.ProductDto;
import com.miu.springsecurity.entity.Product;
import com.miu.springsecurity.entity.Review;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    List<ProductDto> findAll();
    ProductDto findById(int id);
    void save(ProductDto productDto);
    void update(int id, ProductDto productDto);
    void delete(int id);
    List<Product> findAllByPriceGreaterThan(double price);
    List<Product> findAllByCategoryAndPriceLessThan(String cat, double price);
    List<Product> findAllByNameContainingIgnoreCase(String keyword);
    List<Review> findReviewsByProductId(int id);
}
