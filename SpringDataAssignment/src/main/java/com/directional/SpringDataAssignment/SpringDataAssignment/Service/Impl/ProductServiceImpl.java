package com.directional.SpringDataAssignment.SpringDataAssignment.Service.Impl;


import com.directional.SpringDataAssignment.SpringDataAssignment.Entity.BiDirectional.Product;
import com.directional.SpringDataAssignment.SpringDataAssignment.Entity.BiDirectional.Review;
import com.directional.SpringDataAssignment.SpringDataAssignment.Repository.ProductRepo;

import com.directional.SpringDataAssignment.SpringDataAssignment.Service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {

    public final ProductRepo productRepo;


    @Override
    public void saveOrUpdate(Product product) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        var userId = authentication.getName();
        product.getUser().setId(Long.parseLong(userId));
        productRepo.save(product);
    }

    @Override
    public void delete(Long id) {
        productRepo.deleteById(id);
    }


    @Override
    public Product get(Long id) {
        return productRepo.findById(id).get();
    }

    @Override
    public List<Product> getAll() {
        var item = new ArrayList<Product>();
        productRepo.findAll().forEach(item::add);
        return  item;
    }

    @Override
    public List<Product> findProductGreaterThanMinPrice(Double minPrice) {
       var item = productRepo.findByPriceGreaterThan(minPrice);
        return  item;
    }

    @Override
    public List<Product> findByName(String name) {
        return productRepo.findByName(name);
    }

    @Override
    public List<Review> findReviewById(Long id) {
        return productRepo.findById(id).get().getReview();
    }
}
