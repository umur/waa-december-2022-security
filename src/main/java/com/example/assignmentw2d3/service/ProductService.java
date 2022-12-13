package com.example.assignmentw2d3.service;

import com.example.assignmentw2d3.entity.Product;
import com.example.assignmentw2d3.model.ProductRequest;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    public List<Product> getProducts();
    public Optional<Product> getProduct(int productId);
    public String addProduct(ProductRequest productRequest);
    public String deleteProduct(int productId);
}
