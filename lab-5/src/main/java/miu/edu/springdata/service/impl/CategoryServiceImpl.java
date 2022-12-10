package miu.edu.springdata.service.impl;

import lombok.RequiredArgsConstructor;
import miu.edu.springdata.entity.Category;
import miu.edu.springdata.repository.CategoryRepo;
import miu.edu.springdata.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepo categoryRepo;

    public void save(Category address){
        categoryRepo.save(address);
    }

    @Override
    public List<Category> findAll() {
        return (List<Category>) categoryRepo.findAll();
    }

    @Override
    public Category findById(int id) {
        return categoryRepo.findById(id).get();
    }

    @Override
    public void deleteById(int id) {
        categoryRepo.deleteById(id);
    }
}

