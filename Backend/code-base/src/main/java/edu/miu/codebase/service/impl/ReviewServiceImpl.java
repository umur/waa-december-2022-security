package edu.miu.codebase.service.impl;

import edu.miu.codebase.dto.ReviewDto;
import edu.miu.codebase.entity.Review;
import edu.miu.codebase.repository.ReviewRepo;
import edu.miu.codebase.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepo reviewRepo;

    public final ModelMapper modelMapper;

    @Override
    public ReviewDto create(ReviewDto reviewDto) {
        return modelMapper.map(reviewRepo.save(modelMapper.map(reviewDto, Review.class)), ReviewDto.class);
    }

    @Override
    public ReviewDto update(int id, ReviewDto reviewDto) {
        Review review = modelMapper.map(reviewDto, Review.class);
        review = reviewRepo.save(review);
        return modelMapper.map(review, ReviewDto.class);
    }

    @Override
    public void delete(int reviewId) {
        Review review = reviewRepo.findById(reviewId).orElseThrow(() -> new RuntimeException("Review not found"));
        reviewRepo.delete(review);
    }

    ///////////////////////// GET Methods /////////////////////////

    @Override
    public List<ReviewDto> getAll() {
        return reviewRepo.findAll().stream()
                .map(review -> modelMapper.map(review, ReviewDto.class))
                .toList();
    }

    @Override
    public ReviewDto getById(int reviewId) {
        return modelMapper.map(reviewRepo.findById(reviewId).orElseThrow(() -> new RuntimeException("Review not found")), ReviewDto.class);
    }
}
