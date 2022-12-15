package edu.miu.codebase.service;

import edu.miu.codebase.dto.ReviewDto;
import edu.miu.codebase.entity.Review;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ReviewService {

    ReviewDto create(ReviewDto reviewDto);

    ReviewDto update(int reviewId, ReviewDto reviewDto);

    void delete(int reviewId);

    ///////////////////////// GET Methods /////////////////////////

    ReviewDto getById(int reviewId);

    List<ReviewDto> getAll();

}
