package miu.edu.springdata.repository;

import miu.edu.springdata.entity.Review;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepo extends CrudRepository<Review, Integer> {
        Iterable<Review> findReviewsByProductId(int productId);
        }
