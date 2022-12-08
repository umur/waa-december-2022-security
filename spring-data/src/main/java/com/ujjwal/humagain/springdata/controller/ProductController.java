package com.ujjwal.humagain.springdata.controller;

import com.ujjwal.humagain.springdata.aspect.annotation.ExecutionTime;
import com.ujjwal.humagain.springdata.entity.Product;
import com.ujjwal.humagain.springdata.entity.Review;
import com.ujjwal.humagain.springdata.entity.dto.ProductDto;
import com.ujjwal.humagain.springdata.entity.dto.ReviewDto;
import com.ujjwal.humagain.springdata.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping
    @ExecutionTime
    public List<ProductDto> findAll(){
        return productService.findAll();
    }

    @GetMapping("/{id}")
    @ExecutionTime
    public ProductDto findById(@PathVariable int id) {
        return productService.findById(id);
    }

    @PostMapping
    @ExecutionTime
    public void save(@RequestBody ProductDto productDto){
        productService.save(productDto);
    }

    @PutMapping("/{id}")
    @ExecutionTime
    public void update(@PathVariable int id, @RequestBody ProductDto productDto) {
        productService.update(id, productDto);
    }

    @DeleteMapping("/{id}")
    @ExecutionTime
    public void delete(@PathVariable int id) {
        productService.delete(id);
    }

    @GetMapping("/filterByPriceGreaterThan")
    @ExecutionTime
    public List<Product> findAllByPriceGreaterThan(@RequestParam int minPrice){
        return productService.findAllByPriceGreaterThan(minPrice);
    }
    @GetMapping("/filterByName")
    @ExecutionTime
    public List<Product> findAllByNameContaining(@RequestParam String keyword){
        return productService.findAllByNameContaining(keyword);
    }
    @GetMapping("/filterByCategoryAndPriceLessThan")
    @ExecutionTime
    public List<Product> findAllByCategory_NameAndPriceLessThan(@RequestParam String name, @RequestParam int maxPrice){
        return productService.findAllByCategory_NameAndPriceLessThan(name,maxPrice);
    }

    @GetMapping("/{id}/reviews")
    @ExecutionTime
    public List<Review> findAllByProductId(@PathVariable int id){
        return productService.findAllByProductId(id);
    }
}
