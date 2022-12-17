package com.example.lab3springdata.services;


import com.example.lab3springdata.dto.categoryDto.CategoryBasicDto;
import com.example.lab3springdata.entity.Category;

import java.util.List;

public interface CategoryService {
    CategoryBasicDto getById(int id);
    List<CategoryBasicDto> getAll();
    void save(CategoryBasicDto categoryDto);
    void update(int id, CategoryBasicDto categoryDto);
    void delete(int id);

}
