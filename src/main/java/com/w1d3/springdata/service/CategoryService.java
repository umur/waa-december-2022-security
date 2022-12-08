package com.w1d3.springdata.service;

import com.w1d3.springdata.entity.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();
    void save(Category category);
    Category findById(int id);
    void deleteById(int id);

}
