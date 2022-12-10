package com.miu.springsecurity.repository;

import com.miu.springsecurity.entity.Product;
import com.miu.springsecurity.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product,Integer> {
    List<Product> findAllByPriceGreaterThan(double price);
    List<Product> findAllByCategory_NameAndPriceLessThan(String cat, double price);
    List<Product> findAllByNameContainingIgnoreCase(String keyword);

    @Query(value="select reviews from Product where id= :id")
    List<Review> reviewsById(int id);
}
