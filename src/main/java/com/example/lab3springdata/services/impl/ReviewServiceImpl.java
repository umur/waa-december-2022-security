package com.example.lab3springdata.services.impl;

import com.example.lab3springdata.dto.reviewDto.ReviewBasicDto;
import com.example.lab3springdata.entity.Review;
import com.example.lab3springdata.repository.ReviewRepo;
import com.example.lab3springdata.services.ReviewService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepo reviewRepo;
    private final ModelMapper modelMapper;

    public ReviewServiceImpl(ReviewRepo reviewRepo, ModelMapper modelMapper) {
        this.reviewRepo = reviewRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public ReviewBasicDto getById(int id) {
        Review review= reviewRepo.findById(id).get();
        return modelMapper.map(review,ReviewBasicDto.class);
    }

    @Override
    public List<ReviewBasicDto> getAll() {
        List<Review> reviewList = (List<Review>) reviewRepo.findAll();
        return reviewList
                .stream()
                .map(
                        review->modelMapper
                                .map(review,ReviewBasicDto.class))
                .toList();
    }

    @Override
    public void save(ReviewBasicDto reviewDto) {
        Review review = modelMapper.map(reviewDto,Review.class);
        reviewRepo.save(review);
    }

    @Override
    public void update(int id, ReviewBasicDto reviewDto) {

        Review review = modelMapper.map(reviewDto,Review.class);

        Review oldReview = reviewRepo.findById(id).get();
        reviewRepo.delete(oldReview);
        review.setId(id);
        reviewRepo.save(review);
    }

    @Override
    public void delete(int id) {
        reviewRepo.deleteById(id);
    }
}
