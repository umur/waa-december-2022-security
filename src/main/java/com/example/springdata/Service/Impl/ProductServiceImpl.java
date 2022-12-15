package com.example.springdata.Service.Impl;


import com.example.springdata.Entity.Product;
import com.example.springdata.Entity.Review;
import com.example.springdata.Repository.ProductRepo;
import com.example.springdata.Service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {

    public final ProductRepo productRepo;


    @Override
    public void saveOrUpdate(Product product) {
        productRepo.save(product);
    }

    @Override
    public void delete(Integer id) {
        productRepo.deleteById(id);
    }


    @Override
    public Product get(Integer id) {
        return productRepo.findById(id).get();
    }

    @Override
    public List<Product> getAll() {
        var item = new ArrayList<Product>();
        productRepo.findAll().forEach(item::add);
        return  item;
    }

    @Override
    public List<Product> findProductGreaterThanMinPrice(float minPrice) {
       var item = productRepo.findByPriceGreaterThan(minPrice);
        return  item;
    }

    @Override
    public List<Product> findByName(String name) {
        return productRepo.findByName(name);
    }

    @Override
    public List<Review> findReviewById(Integer id) {
        return productRepo.findById(id).get().getReview();
    }
}
