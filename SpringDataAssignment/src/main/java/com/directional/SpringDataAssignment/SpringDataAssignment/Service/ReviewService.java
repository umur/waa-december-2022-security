package com.directional.SpringDataAssignment.SpringDataAssignment.Service;

import com.directional.SpringDataAssignment.SpringDataAssignment.Entity.BiDirectional.Review;

import java.util.List;

public interface ReviewService {
    public void saveorUpdate(Review review);
    public void delete(Long id);

    public Review get(Long id);
    public List<Review> getAll();

}
