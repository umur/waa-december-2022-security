package miu.edu.springdata.service;

import miu.edu.springdata.entity.Category;

import java.util.List;

public interface CategoryService {
    void save(Category category);
    List<Category> findAll();
    Category findById(int id);
    void deleteById(int id);
}
