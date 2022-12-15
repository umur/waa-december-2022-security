package edu.miu.codebase.repository;

import edu.miu.codebase.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {

    List<Product> findAllByPriceGreaterThan(double minPrice);

    List<Product> findAllByNameContaining(String name);

    List<Product> findAllByCategory_NameAndPriceLessThan(String categoryName, double maxPrice);

    List<Product> findAllByUser_Email(String email);
}
