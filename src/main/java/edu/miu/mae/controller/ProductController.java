package edu.miu.mae.controller;

import edu.miu.mae.aspect.annotation.ExecutionTime;
import edu.miu.mae.dto.ProductDto;
import edu.miu.mae.dto.ReviewDto;
import edu.miu.mae.entity.Address;
import edu.miu.mae.entity.Product;
import edu.miu.mae.service.CategoryService;
import edu.miu.mae.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;
@RequestMapping("/product")
@RestController
public class ProductController  extends BaseController<Product, ProductDto> {
    @Autowired
    public ProductController(ProductService as){
        this.bs = as;
    }

    @GetMapping("/moreThanMinPrice")
    public List<ProductDto> moreThanMinPrice(@RequestParam("minPrice") double minPrice){
        ProductService ps =   (ProductService) bs;
        return ps.getAllByPriceGreaterThan(minPrice);
    }

    @GetMapping("/keywords")
    public List<ProductDto> findByKeywords (@RequestParam String keywords){
        ProductService ps =   (ProductService) bs;
        return ps.getAllByNameContaining(keywords);
    }

    //Find reviews of the product whose id is id.
    @GetMapping("/{id}/reviews")
    @ExecutionTime
    public List<ReviewDto> getReviewsByProductId (@PathVariable int id){
        ProductService ps = (ProductService) bs;
        return ps.getReviewsByProductId(id);
    }

    //Find all products in cat category and cost less than maxPrice
    @GetMapping("/categoryAndMaxPrice")
    public List<ProductDto> getAllProductsByCategoryAndPrice (@RequestParam String categoryName,@RequestParam double maxPrice){
        ProductService ps = (ProductService) bs;
        return  ps.getAllProductsByCategoryAndPrice(categoryName,maxPrice);
    }
}