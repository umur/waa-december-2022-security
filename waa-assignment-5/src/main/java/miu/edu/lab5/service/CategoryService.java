package miu.edu.lab5.service;


import miu.edu.lab5.entity.Category;

import java.util.List;

public interface CategoryService {
Category getById (int id);
List<Category> getAll();
void save(Category category);
void update(int id, Category category);
void delete( int id);

}
