package edu.miu.springsecurity.service;

import edu.miu.springsecurity.dto.ProductDto;
import edu.miu.springsecurity.dto.ReviewDto;

public interface ProductService {
    Iterable<ProductDto> getAll();
    ProductDto getById(int id);
    void save(ProductDto product);
    void update(int id, ProductDto product);
    void delete(int id);

    Iterable<ReviewDto> getReviewsById(int id);

    Iterable<ProductDto> findAllByPriceGreaterThan(double minPrice);

    Iterable<ProductDto> findAllByCategoryAndPriceLessThan(String cat, double maxPrice);

    Iterable<ProductDto> findAllByNameContainingIgnoreCase(String name);
}

