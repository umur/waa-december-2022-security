package miu.edu.springdata.service;

import miu.edu.springdata.dto.ReviewDto;
import miu.edu.springdata.entity.Review;

import java.util.List;

public interface ReviewService {
    void save(Review review);
    List<ReviewDto> findAll();
    ReviewDto findById(int id);
    void deleteById(int id);
    List<ReviewDto> findReviewsByProductId(int productId);
}
