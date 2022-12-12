package miu.edu.lab5.repository;


import miu.edu.lab5.entity.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CategoryRepo extends CrudRepository<Category, Integer> {
}
