package com.directional.SpringDataAssignment.SpringDataAssignment.Service.Impl;

import com.directional.SpringDataAssignment.SpringDataAssignment.Entity.BiDirectional.Review;
import com.directional.SpringDataAssignment.SpringDataAssignment.Repository.ReviewRepo;
import com.directional.SpringDataAssignment.SpringDataAssignment.Service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ReviewServiceImpl implements ReviewService {
    public final ReviewRepo reviewRepo;


    @Override
    public void saveorUpdate(Review review) {
        reviewRepo.save(review);
    }

    @Override
    public void delete(Long id) {
        reviewRepo.deleteById(id);
    }


    @Override
    public Review get(Long id) {
        return reviewRepo.findById(id).get();
    }

    @Override
    public List<Review> getAll() {
        var item = new ArrayList<Review>();
        reviewRepo.findAll().forEach(item::add);
        return  item;
    }


}
