package edu.miu.labthree.service;

import edu.miu.labthree.dto.ProductDto;
import edu.miu.labthree.dto.ReviewDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ReviewService {
    void save(ReviewDto reviewDto);
    void delete (int id);
    void update (int id, ReviewDto reviewDto);
    List<ReviewDto> getAll();
    ReviewDto getById(int id);
}
