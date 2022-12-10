package edu.miu.labthree.service.impl;

import edu.miu.labthree.dto.ReviewDto;
import edu.miu.labthree.entity.Review;
import edu.miu.labthree.repository.ReviewRepo;
import edu.miu.labthree.service.ReviewService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ReviewServiceImpl implements ReviewService {

    private final ModelMapper modelMapper;
    private final ReviewRepo reviewRepo;

    public ReviewServiceImpl(ModelMapper modelMapper, ReviewRepo reviewRepo) {
        this.modelMapper = modelMapper;
        this.reviewRepo = reviewRepo;
    }

    @Override
    public void save(ReviewDto reviewDto) {
        Review review = modelMapper.map(reviewRepo, Review.class);
        reviewRepo.save(review);

    }

    @Override
    public void delete(int id) {
        reviewRepo.deleteById(id);

    }

    @Override
    public void update(int id, ReviewDto reviewDto) {
    Review reviewNew = modelMapper.map(reviewDto, Review.class);

    Review review = reviewRepo.findById(id).get();
    reviewRepo.delete(review);
    reviewNew.setId(id);
    reviewRepo.save(reviewNew);

    }

    @Override
    public List<ReviewDto> getAll() {
        List<Review> reviewList =(List<Review>) reviewRepo.findAll();
        return reviewList.stream().map(review -> modelMapper.map(review, ReviewDto.class)).toList();
    }

    @Override
    public ReviewDto getById(int id) {
        Review review = reviewRepo.findById(id).get();
        return modelMapper.map(review,ReviewDto.class);
    }
}
