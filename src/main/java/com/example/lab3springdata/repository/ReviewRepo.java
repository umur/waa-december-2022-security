package com.example.lab3springdata.repository;

import com.example.lab3springdata.entity.Review;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepo extends CrudRepository<Review,Integer> {
}
