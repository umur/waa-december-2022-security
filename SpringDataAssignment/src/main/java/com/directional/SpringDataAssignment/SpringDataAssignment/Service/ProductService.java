package com.directional.SpringDataAssignment.SpringDataAssignment.Service;

import com.directional.SpringDataAssignment.SpringDataAssignment.Entity.BiDirectional.Product;
import com.directional.SpringDataAssignment.SpringDataAssignment.Entity.BiDirectional.Review;


import java.util.List;

public interface ProductService {
    public void saveOrUpdate(Product product);
    public void delete(Long id);
    public Product get(Long id);
    public List<Product> getAll();

    List<Product> findProductGreaterThanMinPrice(Double minPrice);
    List<Product> findByName(String name);


    List<Review> findReviewById(Long id);
}
