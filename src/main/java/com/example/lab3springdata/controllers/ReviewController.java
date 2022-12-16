package com.example.lab3springdata.controllers;

import com.example.lab3springdata.dto.reviewDto.ReviewBasicDto;
import com.example.lab3springdata.services.impl.ReviewServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/reviews")
@RestController
@CrossOrigin
public class ReviewController {
    private final ReviewServiceImpl reviewService;

    public ReviewController(ReviewServiceImpl reviewService) {

        this.reviewService = reviewService;
    }

    @GetMapping
    public List<ReviewBasicDto> getAll(){

        return reviewService.getAll();
    }
    @GetMapping("/{id}")
    public ReviewBasicDto getById(@PathVariable int id){
        return reviewService.getById(id);
    }

    @PostMapping
    public void create(@RequestBody ReviewBasicDto reviewDto){
        reviewService.save(reviewDto);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody ReviewBasicDto reviewDto){
        reviewService.update(id,reviewDto);
    }


    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id){
        reviewService.delete(id);
        return "deleted";
    }



}
