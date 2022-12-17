package edu.miu.mae.service.impl;

import edu.miu.mae.StreamUtils;
import edu.miu.mae.dto.ReviewDto;
import edu.miu.mae.dto.UserDto;
import edu.miu.mae.entity.Product;
import edu.miu.mae.entity.Review;
import edu.miu.mae.entity.User;
import edu.miu.mae.repository.ReviewRepository;
import edu.miu.mae.service.ReviewService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void save(ReviewDto ad) {
            reviewRepository.save(modelMapper.map(ad, Review.class));
    }

    @Override
    public ReviewDto getById(int id) {
        return modelMapper.map(reviewRepository.findById(id).get(), ReviewDto.class);
    }

    @Override
    public void update(ReviewDto ad, int id) {
        Review paramDto = modelMapper.map(ad, Review.class);

        if(paramDto.getId()!=id){
            reviewRepository.deleteById(id);
        }

        reviewRepository.save(paramDto);

    }

    @Override
    public void delete(int id) {
        reviewRepository.deleteById(id);
    }

    @Override
    public List<ReviewDto> getAll() {
        return  StreamUtils
                .asStream(reviewRepository.findAll())
                .map(x->modelMapper.map(x,ReviewDto.class))
                .collect(Collectors.toList());
    }
}
