package com.directional.SpringDataAssignment.SpringDataAssignment.Controller;
import com.directional.SpringDataAssignment.SpringDataAssignment.Entity.BiDirectional.Product;

import com.directional.SpringDataAssignment.SpringDataAssignment.Entity.BiDirectional.Review;
import com.directional.SpringDataAssignment.SpringDataAssignment.Service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/product")
//@CrossOrigin(origins = "http://localhost:3000")
@CrossOrigin
public class ProductController {

    public final ProductService productService;

    @GetMapping("/{id}")
    public Product getById(@PathVariable Long id) {
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
    public void delete(@PathVariable Long id) {
        productService.delete(id);
    }

    @GetMapping("/filterByMinPrice")
    public List<Product>  findProductGreaterThanMinPrice(@RequestParam Double minPrice)
    {
        return  productService.findProductGreaterThanMinPrice(minPrice);
    }

    @GetMapping("/filterByName")
    public List<Product>  findByName(@RequestParam String name)
    {
        return  productService.findByName(name);
    }

    @GetMapping("/filterReviewById")
    public List<Review> findReviewById(@RequestParam Long id)
    {
        return  productService.findReviewById(id);
    }


}
