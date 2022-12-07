package edu.miu.springsecurity.service;

import edu.miu.springsecurity.dto.CategoryDto;

public interface CategoryService {
    Iterable<CategoryDto> getAll();
    CategoryDto getById(int id);
    void save(CategoryDto category);
    void update(int id, CategoryDto category);
    void delete(int id);
}

