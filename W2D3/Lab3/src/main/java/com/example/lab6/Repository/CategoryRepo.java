package com.example.lab6.Repository;

import com.example.lab6.Entity.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepo extends CrudRepository<Category,String> {
}

