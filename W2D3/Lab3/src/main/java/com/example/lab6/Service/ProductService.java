package com.example.lab6.Service;

import com.example.lab6.Entity.Product;
import com.example.lab6.Entity.Review;

import java.util.List;


public interface ProductService {
    public Product save(Product product);
    public void delete(int id);
    public Product get(int id);
    public List<Product> getAll();

    List<Product> findProductGreaterThanMinPrice(Double minPrice);
    List<Product> findByName(String name);
    List<Review> findReviewById(int id);

    List<Product> findAll();
}