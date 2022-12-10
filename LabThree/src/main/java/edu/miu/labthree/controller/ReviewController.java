package edu.miu.labthree.controller;

import edu.miu.labthree.dto.ReviewDto;
import edu.miu.labthree.service.ReviewService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping
    public Iterable<ReviewDto> getAll(){
        return reviewService.getAll();
    }

    @GetMapping("/{id}")
    public ReviewDto getById(@PathVariable int id){
        return reviewService.getById(id);
    }

    @PostMapping
    public void create(@RequestBody ReviewDto reviewDto){
        reviewService.save(reviewDto);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody ReviewDto reviewDto){
        reviewService.update(id, reviewDto);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id){
        reviewService.delete(id);
        return "Review deleted";
    }
}
