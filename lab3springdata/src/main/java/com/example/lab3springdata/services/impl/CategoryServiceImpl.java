package com.example.lab3springdata.services.impl;

import com.example.lab3springdata.dto.categoryDto.CategoryBasicDto;
import com.example.lab3springdata.entity.Category;
import com.example.lab3springdata.repository.CategoryRepo;
import com.example.lab3springdata.services.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepo categoryRepo;
private final ModelMapper modelMapper;
    public CategoryServiceImpl(CategoryRepo categoryRepo, ModelMapper modelMapper) {
        this.categoryRepo = categoryRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public CategoryBasicDto getById(int id) {
        Category category= categoryRepo.findById(id).get();
        return modelMapper.map(category, CategoryBasicDto.class);
    }

    @Override
    public List<CategoryBasicDto> getAll() {
        List<Category> categoryList = (List<Category>) categoryRepo.findAll();
        return categoryList
                .stream()
                .map(category->modelMapper.map(category,CategoryBasicDto.class))
                .toList();
    }

    @Override
    public void save(CategoryBasicDto categoryDto) {
        Category category = modelMapper.map(categoryDto,Category.class);
        categoryRepo.save(category);
    }

    @Override
    public void update(int id, CategoryBasicDto categoryDto) {
        Category category = modelMapper.map(categoryDto,Category.class);

        Category oldCategory = categoryRepo.findById(id).get();
        categoryRepo.delete(oldCategory);
        category.setId(id);
        categoryRepo.save(category);
    }

    @Override
    public void delete(int id) {
        categoryRepo.deleteById(id);
    }
}
