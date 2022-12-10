package edu.miu.labthree.service.impl;

import edu.miu.labthree.dto.CategoryDto;
import edu.miu.labthree.entity.Category;
import edu.miu.labthree.entity.Product;
import edu.miu.labthree.repository.CategoryRepo;
import edu.miu.labthree.service.CategoryService;
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
    public void save(CategoryDto categoryDto) {
        Category category = modelMapper.map(categoryDto, Category.class);
        categoryRepo.save(category);
    }

    @Override
    public void delete(int id) {
        categoryRepo.deleteById(id);

    }

    @Override
    public CategoryDto getById(int id) {
        Category category = categoryRepo.findById(id).get();
        return modelMapper.map(category,CategoryDto.class);
    }

    @Override
    public List<CategoryDto> getAll() {
        List<Category> categoryList = (List<Category>) categoryRepo.findAll();
        return categoryList.stream()
                .map(category -> modelMapper.map(category, CategoryDto.class))
                .toList();
    }

    @Override
    public void update(int id, CategoryDto categoryDto) {
        Category newCategory = modelMapper.map(categoryDto, Category.class);
        Category category = categoryRepo.findById(id).get();
        categoryRepo.delete(category);
        newCategory.setId(id);
        categoryRepo.save(newCategory);
    }

}
