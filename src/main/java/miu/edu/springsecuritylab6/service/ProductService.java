package miu.edu.springsecuritylab6.service;

import miu.edu.springsecuritylab6.entity.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    List<Product> getAllProduct();

    Product getAllProductById(Long id);

    Product addProduct(Product product);

    void deleteProduct(Long id);

    Product updateProduct(Long id, Product product);
}
