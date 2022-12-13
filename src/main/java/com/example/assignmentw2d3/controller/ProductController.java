package com.example.assignmentw2d3.controller;

import com.example.assignmentw2d3.entity.Product;
import com.example.assignmentw2d3.model.ProductRequest;
import com.example.assignmentw2d3.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public List<Product> getProducts() {
        return productService.getProducts();
    }

    @GetMapping("/{productId}")
    public Optional<Product> getProduct(@PathVariable int productId) {
        return productService.getProduct(productId);
    }

    @PostMapping
    public String addProduct(@RequestBody ProductRequest productRequest) {
        return productService.addProduct(productRequest);
    }

    @DeleteMapping("/{productId}")
    public String deleteProduct(@PathVariable int productId) {
        return productService.deleteProduct(productId);
    }
}
