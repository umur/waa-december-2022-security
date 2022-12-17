package com.example.springdata.Service.Impl;


import com.example.springdata.Entity.Review;
import com.example.springdata.Repository.ReviewRepo;
import com.example.springdata.Service.ReviewService;
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
    public void delete(Integer id) {
        reviewRepo.deleteById(id);
    }


    @Override
    public Review get(Integer id) {
        return reviewRepo.findById(id).get();
    }

    @Override
    public List<Review> getAll() {
        var item = new ArrayList<Review>();
        reviewRepo.findAll().forEach(item::add);
        return  item;
    }


}
