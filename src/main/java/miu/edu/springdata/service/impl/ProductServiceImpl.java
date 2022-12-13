package miu.edu.springdata.service.impl;

import lombok.RequiredArgsConstructor;
import miu.edu.springdata.annotation.ExecutionTime;
import miu.edu.springdata.annotation.OffWord;
import miu.edu.springdata.dto.ProductDto;
import miu.edu.springdata.dto.ProductSimpleDto;
import miu.edu.springdata.entity.Product;
import miu.edu.springdata.entity.User;
import miu.edu.springdata.repository.ProductRepo;
import miu.edu.springdata.security.MyUserDetails;
import miu.edu.springdata.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepo productRepo;
    private final ModelMapper mapper;

    @Override
    @ExecutionTime
    @OffWord
    public void save(Product product) {
//        System.out.printf("hello");
        var userId = ((MyUserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUserId();
        var user = new User();
        user.setId(userId);
        product.setUser(user);
//        System.out.println(user+"Hello");
        productRepo.save(product);
    }

    @Override
    @ExecutionTime
    public List<ProductSimpleDto> findAll() {
        return getSimpleDtoList((List<Product>) productRepo.findAll());
    }

    @Override
    public ProductDto findById(int id) {
        return getDto(productRepo.findById(id).get());
    }

    @Override
    public void deleteById(int id) {
        productRepo.deleteById(id);
    }

    @Override
    @ExecutionTime
    public List<ProductDto> findByPriceGreaterThan(double minPrice) {
      return getDtoList((List<Product>) productRepo.findByPriceGreaterThan(minPrice));
    }

    @Override
    public List<ProductDto> findProductsByCategory_NameAndPriceLessThan(String cat, double maxPrice){
        return getDtoList((List<Product>) productRepo.findProductsByCategory_NameIgnoreCaseAndPriceLessThan(cat, maxPrice));
    }

    @Override
    public  List<ProductDto> findProductsByNameContaining(String keyword){
        return getDtoList((List<Product>) productRepo.findProductsByNameContainingIgnoreCase(keyword));
    }

    private List<ProductDto> getDtoList(List<Product> products){
        return products.stream().map(p->{
            return getDto(p);
        }).toList();
    }
    private ProductDto getDto(Product product){
        var test = Product.class;
        return mapper.map(product, ProductDto.class);
    }

    private List<ProductSimpleDto> getSimpleDtoList(List<Product> products){
        return products.stream().map(p->{
            return mapper.map(p, ProductSimpleDto.class);
        }).toList();
    }
}

