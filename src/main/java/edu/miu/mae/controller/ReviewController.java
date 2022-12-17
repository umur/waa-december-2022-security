package edu.miu.mae.controller;

import edu.miu.mae.dto.ReviewDto;
import edu.miu.mae.entity.Product;
import edu.miu.mae.entity.Review;
import edu.miu.mae.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("/review")
@RestController
public class ReviewController extends BaseController<Review, ReviewDto> {
    @Autowired
    public ReviewController(ReviewService as){
        this.bs = as;
    }
}