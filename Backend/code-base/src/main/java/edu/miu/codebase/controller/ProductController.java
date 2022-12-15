package edu.miu.codebase.controller;

import edu.miu.codebase.aspect.executionTime.ExecutionTime;
import edu.miu.codebase.aspect.offensiveWord.OffensiveWordFilter;
import edu.miu.codebase.dto.ProductDto;
import edu.miu.codebase.dto.ReviewDto;
import edu.miu.codebase.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/products")
@CrossOrigin(origins = "http://localhost:3000")
public class ProductController {

    private final ProductService productService;

    @PostMapping
    @ExecutionTime
    public String create(@RequestBody ProductDto productDto) {
        try {
            productService.create(productDto);

            return "Product saved successfully.";
        }
        catch (Exception e) {
            e.printStackTrace();
            return "Error occurred while saving Product.";
        }
    }

    @PutMapping("/{id}")
    @ExecutionTime
    public String update(@PathVariable int id, @RequestBody ProductDto productDto) {
        try {
            productService.update(id, productDto);

            return "Product updated successfully.";
        }
        catch (Exception e) {
            e.printStackTrace();
            return "Error occurred while updating Product.";
        }
    }

    @DeleteMapping("/{id}")
    @ExecutionTime
    public String delete(@PathVariable int id) {
        try {
            productService.delete(id);

            return "Product deleted successfully.";
        }
        catch (Exception e) {
            e.printStackTrace();
            return "Error occurred while deleting Product.";
        }
    }

    ///////////////////////// GET Methods /////////////////////////

    @GetMapping
    @ExecutionTime
    @OffensiveWordFilter
    public ResponseEntity<List<ProductDto>> getAll() {
        return ResponseEntity.ok().body(productService.getAll());
    }

    @GetMapping("/{id}")
    @ExecutionTime
    public ProductDto getById(@PathVariable int id) {
        return productService.getById(id);
    }

    @GetMapping("/filterByPriceGreaterThan")
    @ExecutionTime
    public List<ProductDto> filterAllByPriceGreaterThan(@RequestParam double minPrice) {
        return productService.findAllByPriceGreaterThan(minPrice);
    }

    @GetMapping("/filterByNameContaining")
    @ExecutionTime
    public List<ProductDto> filterAllByNameContaining(@RequestParam String name) {
        return productService.findAllByNameContaining(name);
    }

    @GetMapping("/filterByCategoryAndPriceLessThan")
    @ExecutionTime
    public List<ProductDto> filterAllByNameContaining(@RequestParam String categoryName, @RequestParam double maxPrice) {
        return productService.findAllByCategory_NameAndPriceLessThan(categoryName, maxPrice);
    }

    @GetMapping("/{id}/reviews")
    @ExecutionTime
    public List<ReviewDto> filterReviewsOfProduct(@PathVariable int id){
        return productService.findReviewsOfProduct(id);
    }

}
