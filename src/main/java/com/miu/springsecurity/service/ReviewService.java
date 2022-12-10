package com.miu.springsecurity.service;

import com.miu.springsecurity.dto.ReviewDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ReviewService {
    List<ReviewDto> findAll();
    ReviewDto findById(int id);
    void save(ReviewDto reviewDto);
    void update(int id, ReviewDto reviewDto);
    void delete(int id);
}
