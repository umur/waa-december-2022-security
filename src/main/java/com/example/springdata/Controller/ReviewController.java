package com.example.springdata.Controller;



import com.example.springdata.Entity.Review;
import com.example.springdata.Service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/review")
@CrossOrigin
@PreAuthorize("hasRole('ROLE_ADMIN')")
public class ReviewController {

    public final ReviewService reviewService;

    @GetMapping("/{id}")
    public Review getById(@PathVariable Integer id) {
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
    public void delete(@PathVariable Integer id) {
        reviewService.delete(id);
    }


}
