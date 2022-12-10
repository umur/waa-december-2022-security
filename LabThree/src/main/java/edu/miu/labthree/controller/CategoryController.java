package edu.miu.labthree.controller;

import edu.miu.labthree.dto.CategoryDto;
import edu.miu.labthree.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/categories")
public class CategoryController {
    private final CategoryService categoryService;

    @PostMapping
    public String create(@RequestBody CategoryDto categoryDto) {
        try {
            categoryService.save(categoryDto);

            return "Category saved successfully.";
        }
        catch (Exception e) {
            e.printStackTrace();
            return "Error occurred while saving Category.";
        }
    }

    @PutMapping
    public String update(@PathVariable int id , @RequestBody CategoryDto categoryDto) {
        try {
            categoryService.update(id, categoryDto);

            return "Category updated successfully.";
        }
        catch (Exception e) {
            e.printStackTrace();
            return "Error occurred while updating Category.";
        }
    }

    @DeleteMapping("/{Id}")
    public String delete(@PathVariable int id) {
        categoryService.delete(id);
        return "successfully deleted";
    }


    @GetMapping
    public List<CategoryDto> getAll() {
        return categoryService.getAll();
    }

    @GetMapping("/{id}")
    public CategoryDto getById(@PathVariable int id) {
        return categoryService.getById(id);
    }


}
