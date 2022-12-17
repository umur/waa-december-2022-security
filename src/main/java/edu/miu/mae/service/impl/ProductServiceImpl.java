package edu.miu.mae.service.impl;

import edu.miu.mae.StreamUtils;
import edu.miu.mae.dto.ProductDto;
import edu.miu.mae.dto.ReviewDto;
import edu.miu.mae.entity.Category;
import edu.miu.mae.entity.Product;
import edu.miu.mae.entity.Review;
import edu.miu.mae.repository.CategoryRepository;
import edu.miu.mae.repository.ProductRepository;
import edu.miu.mae.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.nio.file.attribute.UserPrincipal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ModelMapper modelMapper;


    @Override
    public void save(ProductDto ad) {
        UserPrincipal principal = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String email = principal.getName();
        System.out.println("getUserEmail in servicelayer"+email);

        ad.setCreatedByUserEmail(email);
        productRepository.save(modelMapper.map(ad, Product.class));
    }

    @Override
    public ProductDto getById(int id) {

        return  modelMapper
                .map(productRepository
                    .findById(id)
                    .get(),
                    ProductDto.class);
    }

    @Override
    public void update(ProductDto ad, int id) {

        Product paramDto = modelMapper.map(ad, Product.class);
        if(paramDto.getId()!=id){
            productRepository.deleteById(id);
        }
        productRepository.save(paramDto);

    }

    @Override
    public void delete(int id) {
        productRepository.deleteById(id);
    }

    @Override
    public List<ProductDto> getAll() {
        productRepository.findAll();
        return  StreamUtils
                .asStream(productRepository.findAll())
                .map(x->modelMapper.map(x,ProductDto.class))
                .collect(Collectors.toList());
    }


    @Override
    public List<ProductDto> getAllByPriceGreaterThan(double price) {

        return StreamUtils.asStream(productRepository.getAllByPriceGreaterThan(price))
                .map(x->modelMapper.map(x,ProductDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductDto> getAllByNameContaining(String keyword) {
        return StreamUtils.asStream(productRepository.getAllByNameContaining(keyword))
                .map(x->modelMapper.map(x,ProductDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<ReviewDto> getReviewsByProductId(int id) {
        List<Review> reviewsList = productRepository.findById(id).stream().findFirst().get()
                .getReviewsList();

        return reviewsList.stream().map(x->modelMapper.map(x, ReviewDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<ProductDto> getAllProductsByCategoryAndPrice(String categoryName, double maxPrice) {
        List<Product>  products= productRepository.getAllByPriceLessThanAndProductCategoryNameAndProductCategoryPriceGreaterThan(maxPrice,categoryName,100);
//        List<Product>  products=  productRepository.getAllProductsByCategoryAndPrice(categoryName,maxPrice);
        return products.stream().map(x->modelMapper.map(x, ProductDto.class)).collect(Collectors.toList());
    }


}
