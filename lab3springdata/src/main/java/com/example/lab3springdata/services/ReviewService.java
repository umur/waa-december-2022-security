package com.example.lab3springdata.services;

import com.example.lab3springdata.dto.reviewDto.ReviewBasicDto;
import com.example.lab3springdata.entity.Review;

import java.util.List;

public interface ReviewService {
    ReviewBasicDto getById(int id);
    List<ReviewBasicDto>  getAll();
    void save(ReviewBasicDto review);
    void update(int id, ReviewBasicDto review);
    void delete(int id);

}
