package com.example.springdata.Service.Impl;


import com.example.springdata.Entity.Category;
import com.example.springdata.Entity.Product;
import com.example.springdata.Repository.CategoryRepo;
import com.example.springdata.Service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {

    public final CategoryRepo categoryRepo;

    @Override
    public void saveorUpdate(Category category) {
        categoryRepo.save(category);
    }

    @Override
    public void delete(Integer id) {
    categoryRepo.deleteById(id);
    }


    @Override
    public Category get(Integer id) {
        return categoryRepo.findById(id).get();
    }

    @Override
    public List<Category> getAll() {
        var item = new ArrayList<Category>();
        categoryRepo.findAll().forEach(item::add);
        return  item;
    }

    @Override
    public List<Product> getProductByCategoryandPrice(Category category, float maxPrice) {
        Category cat = categoryRepo.findById(category.getId()).get();
        return cat.getProduct().stream().filter(x->x.getPrice()<maxPrice).collect(Collectors.toList());
    }
}
