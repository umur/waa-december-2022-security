package edu.miu.labthree.repository;

import edu.miu.labthree.entity.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepo extends CrudRepository<Category,Integer > {
    Category findByName(String cat);
}
