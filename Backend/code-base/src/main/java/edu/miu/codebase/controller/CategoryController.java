package edu.miu.codebase.controller;

import edu.miu.codebase.dto.CategoryDto;
import edu.miu.codebase.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/categories")
@CrossOrigin(origins = "http://localhost:3000")
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping
    public String create(@RequestBody CategoryDto categoryDto) {
        try {
            categoryService.create(categoryDto);

            return "Category saved successfully.";
        }
        catch (Exception e) {
            e.printStackTrace();
            return "Error occurred while saving Category.";
        }
    }

    @PutMapping("/{id}")
    public String update(@PathVariable int id, @RequestBody CategoryDto categoryDto) {
        try {
            categoryService.update(id, categoryDto);

            return "Category updated successfully.";
        }
        catch (Exception e) {
            e.printStackTrace();
            return "Error occurred while updating Category.";
        }
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {
        try {
            categoryService.delete(id);

            return "Category deleted successfully.";
        }
        catch (Exception e) {
            e.printStackTrace();
            return "Error occurred while deleting Category.";
        }
    }

    ///////////////////////// GET Methods /////////////////////////

    @GetMapping
    public List<CategoryDto> getAll() {
        return categoryService.getAll();
    }

    @GetMapping("/{id}")
    public CategoryDto getById(@PathVariable int id) {
        return categoryService.getById(id);
    }

    @GetMapping("/filterByNameContaining")
    public List<CategoryDto> findAllByNameContaining(@RequestBody String name) {
        return categoryService.findAllByNameContaining(name);
    }

}
