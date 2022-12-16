package com.example.lab3springdata.services.impl;

import com.example.lab3springdata.dto.productDto.ProductBasicDto;
import com.example.lab3springdata.entity.Product;
import com.example.lab3springdata.repository.ProductRepo;
import com.example.lab3springdata.services.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepo productRepo;
    private final ModelMapper modelMapper;

    public ProductServiceImpl(ProductRepo productRepo, ModelMapper modelMapper) {
        this.productRepo = productRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public ProductBasicDto getById(int id) {
        Product product= productRepo.findById(id).get();
        return modelMapper.map(product,ProductBasicDto.class);
    }

    @Override
    public List<ProductBasicDto> getAll() {
        List<Product> productList = (List<Product>) productRepo.findAll();
        return productList
                .stream()
                .map(
                        product->modelMapper
                                .map(product,ProductBasicDto.class))
                .toList();
    }

    @Override
    public void save(ProductBasicDto productDto) {
        Product product = modelMapper.map(productDto,Product.class);
        productRepo.save(product);
    }

    @Override
    public void update(int id, ProductBasicDto productDto) {

        Product product = modelMapper.map(productDto,Product.class);

        Product oldProduct = productRepo.findById(id).get();
        productRepo.delete(oldProduct);
        product.setId(id);
        productRepo.save(product);
    }

    @Override
    public void delete(int id) {
        productRepo.deleteById(id);
    }
}
