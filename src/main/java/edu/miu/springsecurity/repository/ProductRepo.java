package edu.miu.springsecurity.repository;

import edu.miu.springsecurity.entity.Category;
import edu.miu.springsecurity.entity.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepo extends CrudRepository<Product, Integer> {
    //Find all products that cost more than minPrice
    Iterable<Product> findAllByPriceGreaterThan(double minPrice);

    //Find all products in cat category and cost less than maxPrice
    Iterable<Product> findAllByCategoryAndPriceLessThan(Category category, double price);

    //Find all products that contain keyword in the name
    Iterable<Product> findAllByNameContainingIgnoreCase(String name);

}
