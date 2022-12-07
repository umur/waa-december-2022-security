package edu.miu.springsecurity.controller;

import edu.miu.springsecurity.dto.ReviewDto;
import edu.miu.springsecurity.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/reviews")
@RestController
public class ReviewController {

    public final ReviewService reviewService;

    @GetMapping
    public Iterable<ReviewDto> getAll(){
        return reviewService.getAll();
    }

    @GetMapping("/{id}")
    public ReviewDto getById(@PathVariable int id){
        return reviewService.getById(id);
    }

    @PostMapping
    public void create(@RequestBody ReviewDto review){
        reviewService.save(review);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody ReviewDto review){
        reviewService.update(id, review);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        reviewService.delete(id);
    }
}
