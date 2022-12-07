package edu.miu.springsecurity.service;

import edu.miu.springsecurity.dto.ReviewDto;

public interface ReviewService {
    Iterable<ReviewDto> getAll();
    ReviewDto getById(int id);
    void save(ReviewDto review);
    void update(int id, ReviewDto review);
    void delete(int id);
}

