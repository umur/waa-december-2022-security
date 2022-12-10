package edu.miu.springsecurity.controller;

import edu.miu.springsecurity.dto.ProductDto;
import edu.miu.springsecurity.dto.ReviewDto;
import edu.miu.springsecurity.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/products")
@RestController
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public Iterable<ProductDto> getAll(){
        return productService.getAll();
    }

    @GetMapping("/{id}")
    public ProductDto getById(@PathVariable int id){
        return productService.getById(id);
    }

    @PostMapping
    public void create(@RequestBody ProductDto product){
        productService.save(product);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody ProductDto product){
        productService.update(id, product);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        productService.delete(id);
    }

    @GetMapping("/{id}/reviews")
    public Iterable<ReviewDto> getReviewsById(@PathVariable int id){
        return productService.getReviewsById(id);
    }

    @GetMapping("/filter-by-min-price")
    public Iterable<ProductDto> filterByMinPrice(@RequestParam double minPrice){
        return productService.findAllByPriceGreaterThan(minPrice);
    }

    @GetMapping("/filter-by-cat-and-max-price")
    public Iterable<ProductDto> filterByCatAndMaxPrice(@RequestParam String cat, double maxPrice){
        return productService.findAllByCategoryAndPriceLessThan(cat, maxPrice);
    }

    @GetMapping("/filter-by-keyword")
    public Iterable<ProductDto> filterByKeyword(@RequestParam String name){
        return productService.findAllByNameContainingIgnoreCase(name);
    }
}
