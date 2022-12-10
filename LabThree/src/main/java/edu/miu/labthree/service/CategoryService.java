package edu.miu.labthree.service;

import edu.miu.labthree.dto.CategoryDto;
import edu.miu.labthree.entity.Category;
import edu.miu.labthree.entity.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {
    void save(CategoryDto categoryDto);

    void delete(int categoryId);

    CategoryDto getById(int id);

    List<CategoryDto> getAll();
    void update (int id, CategoryDto categoryDto);



}
