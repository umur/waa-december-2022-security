package edu.miu.codebase.service.impl;

import edu.miu.codebase.dto.CategoryDto;
import edu.miu.codebase.entity.Category;
import edu.miu.codebase.repository.CategoryRepo;
import edu.miu.codebase.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepo categoryRepo;

    public final ModelMapper modelMapper;

    @Override
    public CategoryDto create(CategoryDto categoryDto) {
        return modelMapper.map(categoryRepo.save(modelMapper.map(categoryDto, Category.class)), CategoryDto.class);
    }

    @Override
    public CategoryDto update(int categoryId, CategoryDto categoryDto) {
        Category category = modelMapper.map(categoryDto, Category.class);
        category = categoryRepo.save(category);
        return modelMapper.map(category, CategoryDto.class);
    }

    @Override
    public void delete(int categoryId) {
        Category category = categoryRepo.findById(categoryId).orElseThrow(() -> new RuntimeException("Category not found"));
        categoryRepo.delete(category);
    }

    ///////////////////////// GET Methods /////////////////////////

    @Override
    public List<CategoryDto> getAll() {
        return categoryRepo.findAll().stream()
                .map(category -> modelMapper.map(category, CategoryDto.class))
                .toList();
    }

    @Override
    public CategoryDto getById(int categoryId) {
        return modelMapper.map(categoryRepo.findById(categoryId).orElseThrow(() -> new RuntimeException("Category not found")), CategoryDto.class);
    }

    @Override
    public List<CategoryDto> findAllByNameContaining(String name) {
        var categories = categoryRepo.findAllByNameContaining(name);
        return categories.stream()
                .map(category -> modelMapper.map(category, CategoryDto.class))
                .toList();
    }
}
