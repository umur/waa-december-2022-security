package com.example.springdata.Controller;


import com.example.springdata.Entity.Product;
import com.example.springdata.Entity.Review;
import com.example.springdata.Service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/product")
@CrossOrigin
@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
public class ProductController {

    public final ProductService productService;

    @GetMapping("/{id}")
    public Product getById(@PathVariable Integer id) {
       return productService.get(id);
    }

    @GetMapping
    public List<Product> GetAll() {
       return productService.getAll();
    }

    @PostMapping
    public void add(@RequestBody Product product) {
        productService.saveOrUpdate(product);
    }

    @PutMapping
    public void update(@RequestBody Product product) {
        productService.saveOrUpdate(product);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        productService.delete(id);
    }

    @GetMapping("/filterByMinPrice")
    public List<Product>  findProductGreaterThanMinPrice(@RequestParam float minPrice)
    {
        return  productService.findProductGreaterThanMinPrice(minPrice);
    }

    @GetMapping("/filterByName")
    public List<Product>  findByName(@RequestParam String name)
    {
        return  productService.findByName(name);
    }

    @GetMapping("/filterReviewById")
    public List<Review> findReviewById(@RequestParam Integer id)
    {
        return  productService.findReviewById(id);
    }

}
