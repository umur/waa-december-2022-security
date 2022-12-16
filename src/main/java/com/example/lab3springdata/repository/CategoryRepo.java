package com.example.lab3springdata.repository;

import com.example.lab3springdata.entity.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepo extends CrudRepository<Category, Integer> {
}
