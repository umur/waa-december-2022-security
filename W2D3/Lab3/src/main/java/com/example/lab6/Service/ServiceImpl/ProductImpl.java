package com.example.lab6.Service.ServiceImpl;

import com.example.lab6.Entity.Product;
import com.example.lab6.Entity.Review;
import com.example.lab6.Repository.ProductRepo;
import com.example.lab6.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductImpl implements ProductService {

    @Autowired

    private ProductRepo repo;
    public Product save(Product product) {
     return repo.save(product);
    }

    @Override
    public void delete(int id) {
        repo.deleteById(id);

    }

    @Override
    public Product get(int id) {
        return null;
    }

    @Override
    public List<Product> getAll() {
        var rev = new ArrayList<Product>();
        repo.findAll().forEach(rev::add);
        return  rev;
    }

    @Override
    public List<Product> findProductGreaterThanMinPrice(Double minPrice) {
        var prod = repo.findByPriceGreaterThan(minPrice);
        return  prod;
    }

    @Override
    public List<Product> findByName(String name) {
        return repo.findByName(name);
    }

    @Override
    public List<Review> findReviewById(int id) {
        return null;
    }

    @Override
    public List<Product> findAll() {
        return null;
    }
}
