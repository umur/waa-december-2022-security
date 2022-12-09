package com.miu.springsecurity.service;

import com.miu.springsecurity.dto.CategoryDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {
    List<CategoryDto> findAll();
    CategoryDto findById(int id);
    void save(CategoryDto categoryDto);
    void update(int id, CategoryDto categoryDto);
    void delete(int id);
}
