package com.example.springdata.Service;




import com.example.springdata.Entity.Category;
import com.example.springdata.Entity.Product;

import java.util.List;

public interface CategoryService {
    public void saveorUpdate(Category category);
    public void delete(Integer id);
    public Category get(Integer id);
    public List<Category> getAll();

    public List<Product> getProductByCategoryandPrice(Category category, float maxPrice);
}
