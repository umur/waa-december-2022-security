package com.directional.SpringDataAssignment.SpringDataAssignment.Controller;


import com.directional.SpringDataAssignment.SpringDataAssignment.Entity.BiDirectional.Category;

import com.directional.SpringDataAssignment.SpringDataAssignment.Entity.BiDirectional.Product;
import com.directional.SpringDataAssignment.SpringDataAssignment.Service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/categories")
@CrossOrigin
public class CategoryController {

    public final CategoryService categoryService;

    @GetMapping("/{id}")
    public Category getById(@PathVariable Long id) {
       return categoryService.get(id);
    }

    @GetMapping
    public List<Category> GetAll() {
       return categoryService.getAll();
    }

    @PostMapping
    public void add(@RequestBody Category category) {
        categoryService.saveorUpdate(category);
    }

    @PutMapping
    public void update(@RequestBody Category category) {
        categoryService.saveorUpdate(category);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        categoryService.delete(id);
    }

    @GetMapping("/filterByCategoryAndPrice")
    public List<Product> getProductByCategoryAndPrice(@RequestBody Category cat, @RequestParam double maxPrice)
    {
        return categoryService.getProductByCategoryandPrice(cat,maxPrice);
    }

}
