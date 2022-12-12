package com.example.lab6.Repository;

import com.example.lab6.Entity.Review;
import org.springframework.data.repository.CrudRepository;

public interface ReviewRepo extends CrudRepository<Review,Integer> {
}
