package edu.miu.springsecurity.service.impl;

import edu.miu.springsecurity.aspect.annotation.ExecutionTime;
import edu.miu.springsecurity.dto.ProductDto;
import edu.miu.springsecurity.dto.ReviewDto;
import edu.miu.springsecurity.entity.Category;
import edu.miu.springsecurity.entity.Product;
import edu.miu.springsecurity.entity.User;
import edu.miu.springsecurity.repository.CategoryRepo;
import edu.miu.springsecurity.repository.ProductRepo;
import edu.miu.springsecurity.security.AwesomeUserDetails;
import edu.miu.springsecurity.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
//@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
public class ProductServiceImpl implements ProductService {
    private final ProductRepo productRepo;
    private final CategoryRepo categoryRepo;
    private final ModelMapper modelMapper;
    @Override
    public Iterable<ProductDto> getAll() {
        return convertIteratorToList(productRepo.findAll());
    }

    @Override
    public ProductDto getById(int id) {
        return modelMapper.map(productRepo.findById(id).get(), ProductDto.class);
    }

    @Override
    public void save(ProductDto product) {
        var entity = modelMapper.map(product, Product.class);

        //set user_id from current user context
        var authenticationContext = SecurityContextHolder.getContext().getAuthentication();
        var userDetails = (AwesomeUserDetails)authenticationContext.getPrincipal();
        var user = modelMapper.map(userDetails, User.class);
        entity.setUser(user);

        productRepo.save(entity);
    }

    @Override
    public void update(int id, ProductDto product) {
        productRepo.save(modelMapper.map(product, Product.class));
    }

    @Override
    public void delete(int id) {
        productRepo.deleteById(id);
    }

    @Override
    public Iterable<ReviewDto> getReviewsById(int id) {
        return getById(id).getReviews().stream()
                .map(review -> modelMapper.map(review, ReviewDto.class))
                .collect(Collectors.toList());
    }

    @Override
    @ExecutionTime
    public Iterable<ProductDto> findAllByPriceGreaterThan(double minPrice) {
        return convertIteratorToList(productRepo.findAllByPriceGreaterThan(minPrice));
    }

    @Override
    @ExecutionTime
    public Iterable<ProductDto> findAllByCategoryAndPriceLessThan(String cat, double maxPrice) {
        Category category = categoryRepo.findByName(cat);
        return convertIteratorToList(productRepo.findAllByCategoryAndPriceLessThan(category, maxPrice));
    }

    @Override
    @ExecutionTime
    public Iterable<ProductDto> findAllByNameContainingIgnoreCase(String name) {
        return convertIteratorToList(productRepo.findAllByNameContainingIgnoreCase(name));
    }

    private List<ProductDto> convertIteratorToList(Iterable<Product> iterable){
        List<ProductDto> list = new ArrayList<>();
        iterable.forEach(e -> list.add(modelMapper.map(e, ProductDto.class)));
        return list;
    }

//    private <T, U> List<T> convertIteratorToList(Iterable<U> iterable){
//        List<T> list = new ArrayList<T>();
//        iterable.forEach(e -> list.add(modelMapper.map(e, T)));
//        return list;
//    }
}
