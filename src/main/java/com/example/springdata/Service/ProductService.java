package com.example.springdata.Service;




import com.example.springdata.Entity.Product;
import com.example.springdata.Entity.Review;

import java.util.List;

public interface ProductService {
    public void saveOrUpdate(Product product);
    public void delete(Integer id);
    public Product get(Integer id);
    public List<Product> getAll();

    List<Product> findProductGreaterThanMinPrice(float minPrice);
    List<Product> findByName(String name);


    List<Review> findReviewById(Integer id);
}
