package com.example.lab6.Controller;

import com.example.lab6.Entity.Review;
import com.example.lab6.Service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReviewController {
    @Autowired
    public  ReviewService rev;

    @PutMapping
    public void update(@RequestBody Review review) {
        rev.saveorUpdate(review);
    }
    @GetMapping
    public List<Review> GetAll() {
        return rev.getAll();
    }

    @PostMapping
    public void add(@RequestBody Review review) {
        rev.saveorUpdate(review);
    }
    @GetMapping("/{id}")
    public Review getById(@PathVariable int id) {
        return rev.get(id);
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        rev.delete(id);
    }
}
