package miu.edu.springdata.repository;


import miu.edu.springdata.entity.Product;
import miu.edu.springdata.entity.Review;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends CrudRepository<Product, Integer> {
    Iterable<Product> findByPriceGreaterThan(double minPrice);
    Iterable<Product> findProductsByCategory_NameAndPriceLessThan(String cat, double maxPrice);

    Iterable<Product> findProductsByCategory_NameIgnoreCaseAndPriceLessThan(String cat, double maxPrice);
    Iterable<Product> findProductsByNameContainingIgnoreCase(String keyword);
}

