package com.directional.SpringDataAssignment.SpringDataAssignment.Controller;

import com.directional.SpringDataAssignment.SpringDataAssignment.Entity.BiDirectional.Review;
import com.directional.SpringDataAssignment.SpringDataAssignment.Service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/review")
public class ReviewController {

    public final ReviewService reviewService;

    @GetMapping("/{id}")
    public Review getById(@PathVariable Long id) {
       return reviewService.get(id);
    }

    @GetMapping
    public List<Review> GetAll() {
       return reviewService.getAll();
    }

    @PostMapping
    public void add(@RequestBody Review review) {
        reviewService.saveorUpdate(review);
    }

    @PutMapping
    public void update(@RequestBody Review review) {
        reviewService.saveorUpdate(review);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        reviewService.delete(id);
    }


}
