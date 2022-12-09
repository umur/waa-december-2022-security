package com.w1d3.springdata.controller;

import com.w1d3.springdata.entity.Category;
import com.w1d3.springdata.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/categories")
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping
    public List<Category> findAll(){
        return categoryService.findAll();
    }

    @GetMapping("/{id}")
    public Category findById(@PathVariable int id){
        return categoryService.findById(id);
    }
    @PostMapping
    public void save(@RequestBody Category category){
        categoryService.save(category);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody Category category) {
        if (id > 0)
            category.setId(id);
        categoryService.save(category);
    }
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id){
        categoryService.deleteById(id);
    }

 }
