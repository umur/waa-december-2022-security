package com.example.lab3springdata.controllers;
import com.example.lab3springdata.dto.categoryDto.CategoryBasicDto;
import com.example.lab3springdata.services.impl.CategoryServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/categories")
@RestController
public class CategoryController {
    private final CategoryServiceImpl categoryService;

    public CategoryController(CategoryServiceImpl categoryService) {

        this.categoryService = categoryService;
    }

    @GetMapping
    public List<CategoryBasicDto> getAll(){

        return categoryService.getAll();
    }
    @GetMapping("/{id}")
    public CategoryBasicDto getById(@PathVariable int id){
        return categoryService.getById(id);
    }
    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody CategoryBasicDto categoryDto){
        categoryService.update(id,categoryDto);
    }
    @PostMapping
    public void create(@RequestBody CategoryBasicDto categoryDto){
        categoryService.save(categoryDto);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id){
        categoryService.delete(id);
        return "deleted";
    }



}