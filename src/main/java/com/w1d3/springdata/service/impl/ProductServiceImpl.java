package com.w1d3.springdata.service.impl;

import com.w1d3.springdata.aspect.annotation.ExecutionTime;
import com.w1d3.springdata.aspect.annotation.OffensiveWord;
import com.w1d3.springdata.dto.ProductDto;
import com.w1d3.springdata.entity.Product;
import com.w1d3.springdata.entity.User;
import com.w1d3.springdata.repository.ProductRepo;
import com.w1d3.springdata.security.AwesomeUserDetails;
import com.w1d3.springdata.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
public class ProductServiceImpl implements ProductService {
    private final ProductRepo productRepo;
    private final ModelMapper modelMapper;

    @Override
    @ExecutionTime
    @OffensiveWord
    public void save(Product product) {
        var userId=((AwesomeUserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUserId();
        var loggedInUser = new User();
        loggedInUser.setId(userId);
        product.setUser(loggedInUser);
        productRepo.save(product);
    }

    @Override
    @ExecutionTime

    public List<ProductDto> findAll() {
        var productList = (List<Product>) productRepo.findAll();
        return productList.stream().map(p -> modelMapper.map(p, ProductDto.class)).toList();
    }

    @Override
    @ExecutionTime
    public ProductDto findById(int id) {
        var product = productRepo.findById(id).get();
        return modelMapper.map(product, ProductDto.class);
    }

    @Override
    @ExecutionTime
    public void deleteById(int id) {
        productRepo.deleteById(id);

    }
    @ExecutionTime
    public List<ProductDto> findProductsMoreThanMinPrice(double minPrice) {
        return productRepo.findByPriceGreaterThan(minPrice)
                .stream().map(product -> modelMapper
                        .map(product, ProductDto.class)).toList();
    }
    @ExecutionTime
    public List<ProductDto> findByCategoryAnAndPriceLessThan(String cat, double maxPrice) {
        return productRepo.findByCategory_NameIgnoreCaseAndPriceLessThan(cat, maxPrice)
                .stream().map(product -> modelMapper.map(product,ProductDto.class)).toList();
    }
    @ExecutionTime
    @Override
    public List<ProductDto> findByNameContains(String keyword) {
        return productRepo.findByNameContainsIgnoreCase(keyword).stream()
                .map(product -> modelMapper.map(product,ProductDto.class)).toList();
    }
}
