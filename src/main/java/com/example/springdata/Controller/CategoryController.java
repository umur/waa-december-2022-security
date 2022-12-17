package com.example.springdata.Controller;



import com.example.springdata.Entity.Category;
import com.example.springdata.Entity.Product;
import com.example.springdata.Service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/category")
@CrossOrigin
@PreAuthorize("hasRole('ROLE_ADMIN')")
public class CategoryController {

    public final CategoryService categoryService;

    @GetMapping("/{id}")
    public Category getById(@PathVariable Integer id) {
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
    public void delete(@PathVariable Integer id) {
        categoryService.delete(id);
    }

    @GetMapping("/filterByCategoryAndPrice")
    public List<Product> getProductByCategoryAndPrice(@RequestBody Category cat, @RequestParam float maxPrice)
    {
        return categoryService.getProductByCategoryandPrice(cat,maxPrice);
    }

}
