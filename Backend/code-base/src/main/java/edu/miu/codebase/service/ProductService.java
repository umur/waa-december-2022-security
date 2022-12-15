package edu.miu.codebase.service;

import edu.miu.codebase.dto.ProductDto;
import edu.miu.codebase.dto.ReviewDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {

    ProductDto create(ProductDto productDto);

    ProductDto update(int productId, ProductDto productDto);

    void delete(int productId);

    ///////////////////////// GET Methods /////////////////////////

    ProductDto getById(int productId);

    List<ProductDto> getAll();

    List<ProductDto> findAllByPriceGreaterThan(double minPrice);

    List<ProductDto> findAllByNameContaining(String name);

    List<ProductDto> findAllByCategory_NameAndPriceLessThan(String categoryName, double maxPrice);

    List<ReviewDto> findReviewsOfProduct(int id);
}
