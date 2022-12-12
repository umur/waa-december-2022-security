package com.example.lab6.Repository;

import com.example.lab6.Entity.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProductRepo extends CrudRepository<Product,Integer> {
    public List<Product> findByPriceGreaterThan(double minPrice);

    public  List<Product> findByPriceLessThan(int maxPrice);
    public List<Product> findByName(String name);
    public  List<Product> findProduct_ReviewsById(int id);
}
