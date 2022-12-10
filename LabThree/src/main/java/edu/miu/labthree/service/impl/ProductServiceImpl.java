package edu.miu.labthree.service.impl;

import edu.miu.labthree.dto.ProductDto;
import edu.miu.labthree.entity.Category;
import edu.miu.labthree.entity.Product;
import edu.miu.labthree.repository.CategoryRepo;
import edu.miu.labthree.repository.ProductRepo;
import edu.miu.labthree.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

public final ProductRepo repo;
public final ModelMapper modelMapper;
public final CategoryRepo categoryRepo;

    public ProductServiceImpl(ProductRepo repo, ModelMapper modelMapper, CategoryRepo categoryRepo) {
        this.repo = repo;
        this.modelMapper = modelMapper;
        this.categoryRepo = categoryRepo;
    }


    @Override
    public void save(ProductDto productDto) {
        Product product = modelMapper.map(productDto, Product.class);
        repo.save(product);
    }

    @Override
    public void delete(int id) {
        repo.deleteById(id);
    }

    @Override
    public void update(int id, ProductDto productDto) {
        Product newProduct = modelMapper.map(productDto, Product.class);
        Product old = repo.findById(id).get();
        repo.delete(old);
        newProduct.setId(id);
        repo.save(newProduct);


    }

    @Override
    public List<ProductDto> getAll() {
        List<Product> products =(List<Product>) repo.findAll();
        return products.stream().map(product -> modelMapper.map(product, ProductDto.class)).toList();
    }

    @Override
    public ProductDto getById(int id) {
        Product product = repo.findById(id).get();
        return modelMapper.map(product, ProductDto.class);
    }

    @Override
    public List<ProductDto> findAllByPriceGreaterThan(int price) {
        return repo.findAllByPriceGreaterThan(price)
                .stream().toList();
    }

    @Override
    public List<ProductDto> findAllByCategoryCostLessThan(String cat, int price) {
        Category category = categoryRepo.findByName(cat);
        return repo.findAllByNameContainingKeyword(String.valueOf(category), price)
                .stream().toList();
    }

    @Override
    public List<ProductDto> findAllByNameContainingKeyword(String keyword) {
        return repo.findAllByNameContainingKeyword(keyword).stream().toList();
    }
}
