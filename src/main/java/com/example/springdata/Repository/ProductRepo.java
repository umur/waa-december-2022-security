package com.example.springdata.Repository;

import com.example.springdata.Entity.Category;
import com.example.springdata.Entity.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends CrudRepository<Product,Integer> {
    public List<Product> findByPriceGreaterThan(float minPrice);
    public List<Product> findByName(String name);
}
