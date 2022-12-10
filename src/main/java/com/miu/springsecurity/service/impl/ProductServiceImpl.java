package com.miu.springsecurity.service.impl;

import com.miu.springsecurity.dto.ProductDto;
import com.miu.springsecurity.entity.Product;
import com.miu.springsecurity.entity.Review;
import com.miu.springsecurity.repository.ProductRepo;
import com.miu.springsecurity.repository.ReviewRepo;
import com.miu.springsecurity.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import javax.annotation.security.RolesAllowed;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
@PreAuthorize("hasRole('ROLE_USER') || hasRole('ROLE_ADMIN')")
public class ProductServiceImpl implements ProductService {
    private final ProductRepo productRepo;
    private final ReviewRepo reviewRepo;
    private final ModelMapper modelMapper;

    @Override
    public List<ProductDto> findAll() {
        return productRepo.findAll().stream().map(a -> modelMapper.map(a, ProductDto.class)).toList();
    }

    @Override
    public ProductDto findById(int id) {
        return productRepo.findById(id).map(a -> modelMapper.map(a, ProductDto.class)).get();
    }

    @Override
    public void save(ProductDto productDto) {
        Product product = modelMapper.map(productDto, Product.class);
        productRepo.save(product);
    }

    @Override
    public void update(int id, ProductDto productDto) {
        productRepo.findById(id).orElseThrow(() -> new RuntimeException("Product not found."));
        Product product = modelMapper.map(productDto, Product.class);
        productRepo.save(product);
    }

    @Override
    public void delete(int id) {
        Product product = productRepo.findById(id).orElseThrow(() -> new RuntimeException("Product not found."));
        productRepo.delete(product);
    }

    @Override
    public List<Product> findAllByPriceGreaterThan(double price) {
        return productRepo.findAllByPriceGreaterThan(price);
    }

    @Override
    public List<Product> findAllByCategoryAndPriceLessThan(String cat, double price) {
        return productRepo.findAllByCategory_NameAndPriceLessThan(cat, price);
    }

    @Override
    public List<Product> findAllByNameContainingIgnoreCase(String keyword) {
        return productRepo.findAllByNameContainingIgnoreCase(keyword);
    }

    @Override
    public List<Review> findReviewsByProductId(int id) {
        return productRepo.reviewsById(id);
    }
}
