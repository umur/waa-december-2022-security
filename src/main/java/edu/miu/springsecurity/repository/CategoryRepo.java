package edu.miu.springsecurity.repository;

import edu.miu.springsecurity.entity.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepo extends CrudRepository<Category, Integer> {
    Category findByName(String name);
}
