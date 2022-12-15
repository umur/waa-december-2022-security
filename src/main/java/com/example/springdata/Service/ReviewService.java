package com.example.springdata.Service;



import com.example.springdata.Entity.Review;

import java.util.List;

public interface ReviewService {
    public void saveorUpdate(Review review);
    public void delete(Integer id);

    public Review get(Integer id);
    public List<Review> getAll();

}
