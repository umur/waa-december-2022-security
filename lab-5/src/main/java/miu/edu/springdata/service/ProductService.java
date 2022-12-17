package miu.edu.springdata.service;

import miu.edu.springdata.dto.ProductDto;
import miu.edu.springdata.entity.Product;

import java.util.List;

public interface ProductService {
    void save(Product product);
    List<ProductDto> findAll();
    ProductDto findById(int id);
    void deleteById(int id);
    List<ProductDto> findByPriceGreaterThan(double minPrice);
    List<ProductDto> findProductsByCategory_NameAndPriceLessThan(String cat, double maxPrice);
    List<ProductDto> findProductsByNameContaining(String keyword);
}
