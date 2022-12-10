package edu.miu.labthree.service;

import edu.miu.labthree.dto.ProductDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
     void save(ProductDto productDto);
     void delete (int id);
     void update (int id, ProductDto productDto);
     List<ProductDto> getAll();
     ProductDto getById(int id);
     List<ProductDto> findAllByPriceGreaterThan (int price);
     List<ProductDto> findAllByCategoryCostLessThan(String cat, int price);
     List<ProductDto> findAllByNameContainingKeyword(String keyword);

}
