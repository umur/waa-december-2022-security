package edu.miu.springsecurity.service.impl;

import edu.miu.springsecurity.aspect.annotation.ExecutionTime;
import edu.miu.springsecurity.dto.CategoryDto;
import edu.miu.springsecurity.entity.Category;
import edu.miu.springsecurity.repository.CategoryRepo;
import edu.miu.springsecurity.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepo categoryRepo;
    private final ModelMapper modelMapper;
    @Override
    @ExecutionTime
    public Iterable<CategoryDto> getAll() {
        List<CategoryDto> list = new ArrayList<>();
        var categories = categoryRepo.findAll();
        categories.forEach(p -> list.add(modelMapper.map(p, CategoryDto.class)));
        return list;
    }

    @Override
    public CategoryDto getById(int id) {
        return modelMapper.map(categoryRepo.findById(id).get(), CategoryDto.class);
    }

    @Override
    public void save(CategoryDto category) {
        categoryRepo.save(modelMapper.map(category, Category.class));
    }

    @Override
    public void update(int id, CategoryDto category) {
        categoryRepo.save(modelMapper.map(category, Category.class));
    }

    @Override
    public void delete(int id) {
        categoryRepo.deleteById(id);
    }
}
