package com.example.assignmentw2d3.service.impl;

import com.example.assignmentw2d3.aspect.annotation.CheckOffensiveWords;
import com.example.assignmentw2d3.aspect.annotation.RequestFilter;
import com.example.assignmentw2d3.entity.Product;
import com.example.assignmentw2d3.model.ProductRequest;
import com.example.assignmentw2d3.repo.ProductRepo;
import com.example.assignmentw2d3.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProdcutServiceImpl implements ProductService {
    private final ProductRepo productRepo;
    @Override
    public List<Product> getProducts() {
        return productRepo.findAll();
    }

    @Override
    public Optional<Product> getProduct(int productId) {
        return productRepo.findById(productId);
    }

    @Override
    @RequestFilter
    @CheckOffensiveWords
    public String addProduct(ProductRequest productRequest) {
        Product newProduct = new Product();
        newProduct.setName(productRequest.getName());
        newProduct.setPrice(productRequest.getPrice());
        newProduct.setUser(productRequest.getUser());
        productRepo.save(newProduct);
        return "Successfully added new Product!";
    }

    @Override
    public String deleteProduct(int productId) {
        try {
            productRepo.deleteById(productId);
        } catch (Exception e) {
            throw e;
        }
        return "Product deleted successfully!";
    }
}
