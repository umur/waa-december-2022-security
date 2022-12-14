package miu.edu.lab5.controller;

import miu.edu.lab5.entity.Category;
import miu.edu.lab5.service.impl.CategoryServiceImpl;

import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryServiceImpl categoryService;

    public CategoryController(CategoryServiceImpl categoryService) {

        this.categoryService = categoryService;
    }

    @GetMapping
    public List<Category> getAll(){

        return categoryService.getAll();
    }
    @GetMapping("/{id}")
    public Category getById(@PathVariable int id){
        return categoryService.getById(id);
    }
    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody Category category){
        categoryService.update(id,category);
    }
    @PostMapping
    public void create(@RequestBody Category category){
        categoryService.save(category);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id){
        categoryService.delete(id);
        return "deleted";
    }
}
