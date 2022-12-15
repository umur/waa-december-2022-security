package edu.miu.codebase.service.impl;

import edu.miu.codebase.dto.ProductDto;
import edu.miu.codebase.dto.ReviewDto;
import edu.miu.codebase.entity.Product;
import edu.miu.codebase.entity.User;
import edu.miu.codebase.repository.ProductRepo;
import edu.miu.codebase.repository.UserRepo;
import edu.miu.codebase.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepo productRepo;

    private final UserRepo userRepo;

    public final ModelMapper modelMapper;

    public String getUserName() {
        Object user = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;
        if(user instanceof UserDetails)
            username = ((UserDetails) user).getUsername();
        else
            username = user.toString();
        return username;
    }

    @Override
    public ProductDto create(ProductDto productDto) {
        Product product = modelMapper.map(productDto, Product.class);

        product.setUser(userRepo.findByEmail(getUserName()));
        product = productRepo.save(product);
        return modelMapper.map(product, ProductDto.class);
    }

    @Override
    public ProductDto update(int productId, ProductDto productDto) {
        Product product = modelMapper.map(productDto, Product.class);
        product = productRepo.save(product);
        return modelMapper.map(product, ProductDto.class);
    }

    @Override
    public void delete(int productId) {
        Product product = productRepo.findById(productId).orElseThrow(() -> new RuntimeException("Product not found"));
        productRepo.delete(product);
    }

    ///////////////////////// GET Methods /////////////////////////

//    @PreAuthorize("hasRole('ROLE_USER')")
    public List<ProductDto> getAll() {
        User user = userRepo.findByEmail(getUserName());
        List<Product> products;

        if(user.getRoles().stream().anyMatch(role -> role.getRole().equals("ADMIN")))
            products = productRepo.findAll();
        else
            products = productRepo.findAllByUser_Email(getUserName());

        return products.stream()
                .map(product -> modelMapper.map(product, ProductDto.class))
                .toList();
    }

    @Override
    public ProductDto getById(int productId) {
        return modelMapper.map(productRepo.findById(productId).orElseThrow(() -> new RuntimeException("Product not found")), ProductDto.class);
    }

    @Override
    public List<ProductDto> findAllByPriceGreaterThan(double minPrice) {
        var products = productRepo.findAllByPriceGreaterThan(minPrice);

        return products.stream()
                .map(product -> modelMapper.map(product, ProductDto.class))
                .toList();
    }

    @Override
    public List<ProductDto> findAllByNameContaining(String name) {
        var products = productRepo.findAllByNameContaining(name);

        return products.stream()
                .map(product -> modelMapper.map(product, ProductDto.class))
                .toList();
    }

    @Override
    public List<ProductDto> findAllByCategory_NameAndPriceLessThan(String categoryName, double maxPrice) {
        var products = productRepo.findAllByCategory_NameAndPriceLessThan(categoryName, maxPrice);

        return products.stream()
                .map(product -> modelMapper.map(product, ProductDto.class))
                .toList();
    }

    @Override
    public List<ReviewDto> findReviewsOfProduct(int id) {
        var reviews = productRepo.findById(id).orElseThrow(() -> new RuntimeException("Product not found")).getReviews();

        return reviews.stream()
                .map(r -> modelMapper.map(r, ReviewDto.class)).toList();
    }

}
