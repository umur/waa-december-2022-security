package com.w1d3.springdata.service;

import com.w1d3.springdata.dto.ReviewDto;
import com.w1d3.springdata.entity.Review;

import java.util.List;

public interface ReviewService {
    void save(Review review);
    List<ReviewDto> findAll();
    ReviewDto findById(int id);
    void deleteById(int id);

    List<ReviewDto> reviewsByProductId(int id);
}
