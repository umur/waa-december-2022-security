package miu.edu.springdata.repository;


import miu.edu.springdata.entity.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepo extends CrudRepository<Category, Integer> {
}
