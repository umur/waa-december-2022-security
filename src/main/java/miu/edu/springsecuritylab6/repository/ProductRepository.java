package miu.edu.springsecuritylab6.repository;

import miu.edu.springsecuritylab6.entity.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
}
