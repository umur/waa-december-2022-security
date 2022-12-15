package edu.miu.codebase.service;

import edu.miu.codebase.dto.CategoryDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {

    CategoryDto create(CategoryDto categoryDto);

    CategoryDto update(int categoryId, CategoryDto categoryDto);

    void delete(int categoryId);

    ///////////////////////// GET Methods /////////////////////////

    List<CategoryDto> getAll();

    CategoryDto getById(int categoryId);

    List<CategoryDto> findAllByNameContaining(String name);

}
