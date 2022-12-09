package com.miu.springsecurity.service.impl;

import com.miu.springsecurity.dto.ReviewDto;
import com.miu.springsecurity.entity.Review;
import com.miu.springsecurity.repository.ReviewRepo;
import com.miu.springsecurity.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@Service
@RequiredArgsConstructor
@PreAuthorize("hasRole('ROLE_ADMIN')")
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepo reviewRepo;
    private final ModelMapper modelMapper;

    @Override
    public List<ReviewDto> findAll() {
        return reviewRepo.findAll().stream().map(a -> modelMapper.map(a, ReviewDto.class)).toList();
    }

    @Override
    public ReviewDto findById(int id) {
        return reviewRepo.findById(id).map(a -> modelMapper.map(a, ReviewDto.class)).get();
    }

    @Override
    public void save(ReviewDto reviewDto) {
        Review review = modelMapper.map(reviewDto, Review.class);
        reviewRepo.save(review);
    }

    @Override
    public void update(int id, ReviewDto reviewDto) {
        reviewRepo.findById(id).orElseThrow(() -> new RuntimeException("Review not found."));
        Review review = modelMapper.map(reviewDto, Review.class);
        reviewRepo.save(review);
    }

    @Override
    public void delete(int id) {
        Review review = reviewRepo.findById(id).orElseThrow(() -> new RuntimeException("Review not found."));
        reviewRepo.delete(review);
    }
}
