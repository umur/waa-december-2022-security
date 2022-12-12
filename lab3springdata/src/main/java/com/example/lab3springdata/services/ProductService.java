package com.example.lab3springdata.services;

import com.example.lab3springdata.dto.productDto.ProductBasicDto;
import com.example.lab3springdata.entity.Product;

import java.util.List;

public interface ProductService {
    ProductBasicDto getById(int id);
    List<ProductBasicDto>  getAll();
    void save(ProductBasicDto product);
    void update(int id, ProductBasicDto product);
    void delete(int id);

}
