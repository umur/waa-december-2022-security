package edu.miu.labthree.repository;

import edu.miu.labthree.entity.Review;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepo extends CrudRepository<Review,Integer > {
    List<Review> findByProductId(int id);
}
