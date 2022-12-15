package miu.edu.springdata.service.impl;

import lombok.RequiredArgsConstructor;
import miu.edu.springdata.annotation.ExecutionTime;
import miu.edu.springdata.dto.ProductDto;
import miu.edu.springdata.dto.ReviewDto;
import miu.edu.springdata.entity.Product;
import miu.edu.springdata.entity.Review;
import miu.edu.springdata.repository.ReviewRepo;
import miu.edu.springdata.service.ReviewService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepo reviewRepo;
    private  final ModelMapper mapper;

    @Override
    @ExecutionTime
    public void save(Review address){
        reviewRepo.save(address);
    }

    @Override
    public List<ReviewDto> findAll() {
        return getDtoList ((List<Review>) reviewRepo.findAll());
    }

    @Override
    public ReviewDto findById(int id) {
        return getDto(reviewRepo.findById(id).get());
    }

    @Override
    public void deleteById(int id) {
        reviewRepo.deleteById(id);
    }

    @Override
    public List<ReviewDto> findReviewsByProductId(int productId){
        return getDtoList ((List<Review>) reviewRepo.findReviewsByProductId(productId));
    }


    private List<ReviewDto> getDtoList(List<Review> reviews){
        return reviews.stream().map(p->{
            return getDto(p);
        }).toList();
    }
    private ReviewDto getDto(Review review){
        return mapper.map(review, ReviewDto.class);
    }
}
